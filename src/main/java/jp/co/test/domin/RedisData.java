package jp.co.test.domin;

import java.io.Serializable;

@lombok.Data
public class RedisData implements Serializable {
    private Integer id;
    private String name;
}
