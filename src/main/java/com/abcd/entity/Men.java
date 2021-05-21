package com.abcd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: TestMaven
 * @description:
 * @author: Liu Xinpeng
 * @create: 2021-05-21 17:17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Men implements Cloneable, Serializable {

    private String name;
}