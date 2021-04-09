package com.example.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.common.entity.CommonResult;

/**
 * @author Castle
 * @Date 2021/4/9 15:10
 */
public class MyBlockHandler {
    /**
     * blockHandler 对应处理 BlockException 的函数名称，可选项。
     * blockHandler 函数访问范围需要是 public，
     * 返回类型需要与原方法相匹配，参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 BlockException。
     * blockHandler 函数默认需要和原方法在同一个类中。
     * 若希望使用其他类的函数，则可以指定 blockHandlerClass 为对应的类的 Class 对象，
     * 注意对应的函数必需为 static 函数，否则无法解析。
     */
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(44, "自定义的全局handlerException------->1");
    }

    public static CommonResult handlerAnotherException(BlockException exception) {
        return new CommonResult(4444, "自定义的全局handlerException------->2");
    }
}
