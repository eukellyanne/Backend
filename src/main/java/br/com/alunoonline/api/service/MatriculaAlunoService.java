package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.AtualizarNotasRequest;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponse;
import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MatriculaAlunoService {

    public static final double MEDIA_PARA_APROVACAO = 7.0;

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    /*
    É aqui que o aluno vai se matricular
     */

    public void criarMatricula(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    /*
    É aqui que o aluno vai trancar sua matrícula em alguma disciplina
     */

    public void trancarMatricula(Long matriculaAlunoId) {
        MatriculaAluno matriculaAluno =
                matriculaAlunoRepository.findById(matriculaAlunoId)
                        .orElseThrow(() ->
                                new ResponseStatusException(HttpStatus.NOT_FOUND,
                                        "Matricula Aluno não encontrada!"));

        if (MatriculaAlunoStatusEnum.MATRICULADO.equals(matriculaAluno.getStatus())) {
            //Lançar o erro se o status não for matriculado
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Só é possível trancar uma matricula com status MATRICULADO");
        }

        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.TRANCADO);

        matriculaAlunoRepository.save(matriculaAluno);

    }

    public void atualizaNotas(Long matriculaAlunoId,
                              AtualizarNotasRequest atualizarNotasRequest) {
        MatriculaAluno matriculaAluno =
                matriculaAlunoRepository.findById(matriculaAlunoId)
                        .orElseThrow(() ->
                                new ResponseStatusException(HttpStatus.NOT_FOUND,
                                        "Matricula Aluno não encontrada"));

        //verifica se o front esta mandando a nota1
        //if (atualizarNotasRequest.getNota1() != null): Traz nota que vem do front
        if (atualizarNotasRequest.getNota1() != null) {
            //matriculaAluno.setNota1: Atualiza a nota1 que vem atualmente do Banco
            matriculaAluno.setNota1(atualizarNotasRequest.getNota1());
        }

        //verifica se o front esta mandando a nota2
        //if (atualizarNotasRequest.getNota2() != null): Traz nota que vem do front
        if (atualizarNotasRequest.getNota2() != null) {
            //matriculaAluno.setNota2: Atualiza a nota2 que vem atualmente do Banco
            matriculaAluno.setNota2(atualizarNotasRequest.getNota2());

        }

        calculaMedia(matriculaAluno);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public void calculaMedia(MatriculaAluno matriculaAluno) {
        Double nota1 = matriculaAluno.getNota1();
        Double nota2 = matriculaAluno.getNota2();

        if (nota1 != null && nota2 != null) {
            Double media = (nota1 + nota2) / 2;
            matriculaAluno.setStatus(media >= MEDIA_PARA_APROVACAO ? MatriculaAlunoStatusEnum.APROVADO : MatriculaAlunoStatusEnum.REPROVADO);
        }

    }

    public HistoricoAlunoResponse emitirHistorico(Long alunoId) {
        List<MatriculaAluno> matriculasdoAluno = matriculaAlunoRepository.findByAlunoId(alunoId);

        if (matriculasdoAluno.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Esse aluno não possui matriculas");


        }
        return null;
    }
}
