package client.utils;

import com.tecnara.weather.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {


    @Test
    public void checkerTestOK(){

        //1. Inicializacion del entono

        String coordenates = "{\"lon\":" + 87.25 + ", \"lat\":" + 93.42 + "}";

        //2. Ejecucion del codigo

        boolean resultado = Utils.checker(coordenates);

        //3. Comprobacion de resultado

        Assertions.assertEquals(true,resultado);

    }
}
