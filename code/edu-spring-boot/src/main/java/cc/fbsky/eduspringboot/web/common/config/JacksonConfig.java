package cc.fbsky.eduspringboot.web.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

@Deprecated
//@Configuration
public class JacksonConfig {

    @Autowired
    private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    @Bean
    public MappingJackson2HttpMessageConverter MappingJsonpHttpMessageConverter() {

        ObjectMapper mapper = jackson2ObjectMapperBuilder.build();

        CustumDateFormat custumDateFormat = new  CustumDateFormat();
        mapper.setDateFormat(custumDateFormat);

        return  new MappingJackson2HttpMessageConverter(mapper);
    }

    public static class  CustumDateFormat extends DateFormat {

        @Override
        public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
            return new StringBuffer();
        }

        @Override
        public Date parse(String source, ParsePosition pos) {
            return new Date();
        }
    }
}
