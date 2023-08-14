package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("半年後にエンジニアとして転職する！");

        //filter:条件を満たした値を抽出するメソッド
        List<String> entitylist = Arrays.asList("Player","Goat","Cow");
        // 文字列の長さが3のものを抽出する
        List<String> filterList = entitylist.stream()
            .filter(entity -> entity.length() == 3)
            .collect(Collectors.toList());
        System.out.println(filterList);
        // 実行結果[Cow]

        //map to XX :mapは値を変換するメソッド。 map,mapToInt,mapToLongなど様々な型のオブジェクトへ変更できる。
        // entitylistの中身を全て大文字へ変換する
        entitylist.stream()
            .map(String::toUpperCase)
            // ↑.map(entity -> entity.toUpperCase())
            .forEach(s -> System.out.println(s + " "));
         /* ↑'forEach'メソッドを使ってストリーム内の要素を順番に処理する。
           ラムダ式は、各要素を受け取って出力する処理。大文字に変換された要素の後ろにスペースを追加している。
         */

        //sort:要素をソートする。数値は昇順、文字列はアルファベット順。
        entitylist.stream()
            .sorted()
            .forEach(System.out::println);

        //limit : 指定された個数までに限定するメソッド
        List<String> fivelist = Arrays.asList("Player","Goat","Cow","Chicken","Mob");
        // 表示するのは2つまでに限定する
        fivelist.stream()
            .limit(2)
            .forEach(System.out::println);

        //distinct:重複した値を取り除くメソッド
        List<String> charalist = Arrays.asList("Pikachu","Pikachu","Satoshi","Conan","Satoshi");
        charalist.stream()
            .distinct()
            .forEach(System.out::println);

        //collect :あるコレクションを別のコレクションへ変換する際に便利な集約処理を行うメソッド
        // 文字列を大文字に変換し、「,」で連結
        System.out.println(
            fivelist.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","))
        );

        //toArray:配列に変換するメソッド
        String[] entityArray = fivelist.stream()
            .map(String::toUpperCase)
            .toArray(String[]::new);
        System.out.println(Arrays.toString(entityArray));

        //count:要素数を返却するメソッド
        System.out.println(fivelist.stream().count());

        //max/min:最大値/最小値を返すメソッド
        // 文字列の長さが最小のentityを出力
        System.out.println(fivelist.stream().min((s,t) -> s.length() - t.length()));
        // 文字列の長さが最大のentityを出力
        System.out.println(fivelist.stream().max((s,t) -> s.length() - t.length()));
        // ラムダ式"(s,t) -> s.length~"は2つの要素sとtの文字列長を比べて短い/長い方を選択する比較関数を表す。

        //sum:合計値を返すメソッド
        //文字列の長さの合計を算出
        System.out.println(fivelist.stream().mapToInt(i -> i.length()).sum());

        //findfirst:先頭の値を返すメソッド
        // Cから始まる最初のEntityを出力
        Optional foundEntity = entitylist.stream()
            .filter(e -> e.startsWith("C")).findFirst();
        System.out.println(foundEntity);

        //anyMatch:1つでも条件に合う値があるか確認するメソッド。合致する値があればtrueを返す。
        // Cから始まるEntityが1つでもあるかチェック
        System.out.println(entitylist.stream().anyMatch(e -> e.startsWith("C")));

        //allMatch:全ての値が条件に合致するか確認するメソッド。合致すればtrueを返す。
        // 全てのEntityがCから始まるかチェック
        System.out.println(entitylist.stream().allMatch(e -> e.startsWith("C")));

        //foreach:コレクションの要素をイテレートする＝要素ごとに繰り返し処理をする。
        // 処理内容はforEach()の引数内に指定する。
        fivelist.stream().filter(s -> s.length() > 5)
            .limit(2)
            .forEach(System.out::println);

    }
}