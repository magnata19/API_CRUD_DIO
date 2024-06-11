package com.restexample.restful.controller;

import com.restexample.restful.enums.Erros;
import com.restexample.restful.exception.ValidaNullable;
import com.restexample.restful.exception.ValidaPrecoProduto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidaNullable.class)
    public ResponseEntity<Object> validaNullable(){
        Map<String, Object> body = new HashMap<>();
        body.put("Erro: ", Erros.VALIDA_ERRO_NULO.getMensagem());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ValidaPrecoProduto.class)
    public ResponseEntity<Object> validaPrecoProduto() {
        Map<String, Object> body = new HashMap<>();
        body.put("Erro: ", Erros.VALIDA_PRECO_PRODUTO.getMensagem());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
