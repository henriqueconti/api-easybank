package br.com.easybank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceConta;
    private String resourceNomeAtributo;
    private Object resourceAtributo;

    public ResourceNotFoundException( String resourceConta, String resourceNomeAtributo, Object resourceAtributo) {
        super(String.format("%s não encontrado %s : '%s'", resourceNomeAtributo, resourceNomeAtributo, resourceAtributo));
        this.resourceConta = resourceConta;
        this.resourceNomeAtributo = resourceNomeAtributo;
        this.resourceAtributo = resourceAtributo;
    }

    public String getResourceConta() {
        return resourceConta;
    }

    public String getResourceNomeAtributo() {
        return resourceNomeAtributo;
    }

    public Object getResourceAtributo() {
        return resourceAtributo;
    }
    
}