package com.mdx.lib.hero;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class HeroData {

    //编号
    @ExcelProperty("no")
    private String no;
    //称号
    @ExcelProperty("title")
    private String title;

    //名称 英文
    @ExcelProperty("name_en")
    private String nameEn;

    //名称 中文
    @ExcelProperty("name_cn")
    private String nameCn;

    //角色
    @ExcelProperty("role")
    private String role;

    //攻击力
    @ExcelProperty("phy_atk")
    private String phyAtk;

    //防御力
    @ExcelProperty("phy_def")
    private String phyDef;

    //法强
    @ExcelProperty("magic_atk")
    private String magicAtk;

    //魔抗
    @ExcelProperty("magic_def")
    private String magicDef;

}
