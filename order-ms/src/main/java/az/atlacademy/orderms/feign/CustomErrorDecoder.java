package az.atlacademy.orderms.feign;

import az.atlacademy.orderms.exception.NotFoundException;
import az.atlacademy.orderms.model.ExceptionMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.coyote.BadRequestException;

import java.io.IOException;
import java.io.InputStream;

public class CustomErrorDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        String  message = null;
        try (InputStream bodyIs = response.body().asInputStream()) {
            //ObjectMapper mapper = new ObjectMapper();
            message = bodyIs.toString();
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        return switch (response.status()) {
            case 400 -> new BadRequestException(message);
            case 404 -> new NotFoundException(message);
            default -> errorDecoder.decode(methodKey, response);
        };
    }

}

