package dev.marksduarte.cnbsserproclient.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public final class BeanUtils {
    // adicionado como 'static' para chamar direto na classe.
    private static ApplicationContext context;

    private BeanUtils(ApplicationContext context) {
        BeanUtils.context = context;
    }

    /**
     * Recupera o Bean instanciado no contexto.
     * @param clazz Classe a ser localizada.
     * @return Objeto bean instanciado no contexto.
     * @param <T> Tipo do objeto da classe.
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        Assert.state(context != null, "O contexto do Spring ainda não foi inicializado!");
        return context.getBean(clazz);
    }

    /**
     * Verifica se a propriedade existe no arquivo de 'applicaton.properties' existe e está ativa: true ou on.
     * @param key Chave tipo: spring.data.key
     * @return true ou false
     */
    public static boolean isPropertyActivated(String key) {
        Assert.state(context != null, "O contexto do Spring ainda não foi inicializado!");
        var value = context.getEnvironment().getProperty(key);
        return value != null && (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("on"));
    }
}
