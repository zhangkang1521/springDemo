package org.zk.convert;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;
import org.zk.entity.DemoObj;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 4/24/2018.
 */
public class MyMessageConvert extends AbstractHttpMessageConverter<DemoObj> {

    public MyMessageConvert() {
        super(new MediaType("application", "demoobj", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String tmp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String[] arr = tmp.split(",");
        DemoObj demoObj = new DemoObj(arr[0], arr[1]);
        return demoObj;
    }

    @Override
    protected void writeInternal(DemoObj demoObj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String str = "demoObj:" + demoObj.getA() + "," + demoObj.getB();
        outputMessage.getBody().write(str.getBytes(Charset.forName("UTF-8")));
    }
}
