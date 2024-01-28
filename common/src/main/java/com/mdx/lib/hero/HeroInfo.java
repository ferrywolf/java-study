package com.mdx.lib.hero;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class HeroInfo {
    //编号
    private int no;
    //称号
    private String title;

    //名称 英文
    private String nameEn;

    //名称 中文
    private String nameCn;

    //角色
    private String role;

    //攻击力
    private int phyAtk;

    //防御力
    private int phyDef;

    //法强
    private int magicAtk;

    //魔抗
    private int magicDef;

    private HeroInfo(HeroData heroData){
        this.no = Integer.parseInt(heroData.getNo());
        this.title = heroData.getTitle();
        this.nameEn = heroData.getNameEn();
        this.nameCn = heroData.getNameCn();
        this.role = heroData.getRole();
        this.phyAtk = Integer.parseInt(heroData.getPhyAtk());
        this.phyDef = Integer.parseInt(heroData.getPhyDef());
        this.magicAtk = Integer.parseInt(heroData.getMagicAtk());
        this.magicDef = Integer.parseInt(heroData.getMagicDef());
    }

    public static HeroInfo from(HeroData heroData){
        return new HeroInfo(heroData);
    }
}
