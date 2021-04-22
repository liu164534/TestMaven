package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: TestMaven
 * @description:
 * @author: Liu Xinpeng
 * @create: 2021-04-22 10:33
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestVo {

    /**
     * 名称
     */
    private String name;

}