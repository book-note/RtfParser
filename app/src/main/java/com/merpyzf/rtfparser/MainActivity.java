package com.merpyzf.rtfparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.merpyzf.rtf_parser.exception.PlainTextExtractorException;
import com.merpyzf.rtf_parser.exception.UnsupportedMimeTypeException;
import com.merpyzf.rtf_parser.parser.PlainTextExtractor;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String demo = "{\\rtf1\\ansi\\ansicpg936\\cocoartf2576\n" +
                "\\cocoatextscaling0\\cocoaplatform0{\\fonttbl\\f0\\fswiss\\fcharset0 Helvetica;}\n" +
                "{\\colortbl;\\red255\\green255\\blue255;\\red254\\green207\\blue137;\\red255\\green235\\blue127;}\n" +
                "{\\*\\expandedcolortbl;;\\cssrgb\\c100000\\c84314\\c60392;\\cssrgb\\c100000\\c92941\\c56863;}\n" +
                "\\pard\\tx560\\tx1120\\tx1680\\tx2240\\tx2800\\tx3360\\tx3920\\tx4480\\tx5040\\tx5600\\tx6160\\tx6720\\pardirnatural\\partightenfactor0\n" +
                "\n" +
                "\\f0\\fs24 \\cf0 \\uc0\\u39029 \\u38754  47\\\n" +
                "\\\n" +
                "\\cb2 \\uc0\\u20570 \\u20303 \\u38498 \\u21307 \\u29983 \\u26089 \\u26399 \\u65292 \\u25105 \\u35760 \\u24471 \\u30475 \\u36807 \\u19968 \\u37096 \\u20851 \\u20110 \\u20013 \\u22269 \\u23569 \\u26519 \\u23546 \\u30340 \\u32426 \\u24405 \\u29255 \\u12290 \\u29255 \\u23376 \\u37324 \\u30340 \\u21644 \\u23578 \\u22312 \\u19968 \\u24231 \\u20559 \\u20731 \\u30340 \\u23546 \\u24217 \\u37324 \\u25509 \\u21463 \\u38271 \\u36798 \\u21313 \\u20313 \\u24180 \\u30340 \\u35757 \\u32451 \\u65292 \\u27599 \\u22825 \\u20940 \\u26216 5\\u28857 \\u36215 \\u24202 \\u65292 \\u32451 \\u21040 \\u21320 \\u22812 \\u25165 \\u20572 \\u65292 \\u25226 \\u33258 \\u24049 \\u23436 \\u20840 \\u25176 \\u20184 \\u32473 \\u20102 \\u19968 \\u31181 \\u31105 \\u27442 \\u20027 \\u20041 \\u30340 \\u20154 \\u29983 \\u65292 \\u19981 \\u21463 \\u29289 \\u27442 \\u24433 \\u21709 \\u12290 \\u24403 \\u26102 \\u25105 \\u24819 \\u65306 \\u36825 \\u26679 \\u30340 \\u26085 \\u23376 \\u20063 \\u19981 \\u31639 \\u22826 \\u31967 \\u22043 \\u65292 \\u33267 \\u23569 \\u20182 \\u20204 \\u19981 \\u29992 \\u27599 \\u24180 \\u25442 \\u19968 \\u24231 \\u23436 \\u20840 \\u19981 \\u21516 \\u30340 \\u23546 \\u24217 \\u65292 \\u28982 \\u21518 \\u32763 \\u22825 \\u35206 \\u22320 \\u22320 \\u37325 \\u26032 \\u23433 \\u25490 \\u33258 \\u24049 \\u30340 \\u20154 \\u29983 \\u12290 \\cb1 \\\n" +
                "\\\n" +
                "\\cb3 \\uc0\\u19988 \\u23436 \\u20840 \\u19981 \\u27838 \\u36793 \\u30340 \\u34892 \\u25919 \\u21306 \\u12290 \\u21478 \\u19968 \\u20010 \\u20998 \\u21306 \\u21483 \\u33487 \\u26684 \\u20848 \\u12290 \\u20320 \\u30693 \\u36947 \\u65292 \\u33487 \\u26684 \\u20848 \\u23601 \\u26159 \\'97\\'97\\u24590 \\u20040 \\u35828 \\u26469 \\u30528 \\u65292 \\u27809 \\u38169 \\'97\\'97\\u19968 \\u22359 \\u38754 \\u31215 \\u36275 \\u36275 \\u26377 3\\u19975 \\u24179 \\u26041 \\u33521 \\u37324 \\u30340 \\u20065 \\u26449 \\u22320 \\u24102 \\u12290 \\u20551 \\u22914 \\u27492 \\u21051 \\u20320 \\u27491 \\u22312 \\u32771 \\u34385 \\u32622 \\u21150 \\u33258 \\u24049 \\u30340 \\u31532 \\u19968 \\u25152 \\u25151 \\u23376 \\u65292 \\u30495 \\u30340 \\u24456 \\u38590 \\u22312 \\u33487 \\u26684 \\u20848 \\u22320 \\u21306 \\u25214 \\u21040 \\u19968 \\u20010 \\u36317 \\u31163 \\u33487 \\u26684 \\u20848 \\u25152 \\u26377 \\u22478 \\u38215 \\u37117 \\u24456 \\u36817 \\u30340 \\u22320 \\u26041 \\u12290 \\u19968 \\u24180 \\u25442 \\u19968 \\u20004 \\u27425 \\u31199 \\u25151 \\u21327 \\u35758 \\u24050 \\u32463 \\u22815 \\u26377 \\u30149 \\u30340 \\u20102 \\u65292 \\u26356 \\u21035 \\u35828 \\u20998 \\u21306 \\u37096 \\u38376 \\u22312 \\u25552 \\u20379 \\u25644 \\u23478 \\u36153 \\u29992 \\u26041 \\u38754 \\u24456 \\u26377 \\u24515 \\u26426 \\u22320 \\u37319 \\u21462 \\u20102 \\u19968 \\cb1 \\\n" +
                "\\\n" +
                "\\uc0\\u27979 \\u35797 \\\n" +
                "\\\n" +
                "\\\n" +
                "}";

        InputStream stream = new ByteArrayInputStream(demo.getBytes(StandardCharsets.UTF_8));
        PlainTextExtractor extractor = new PlainTextExtractor();
        try {
            String text = extractor.extract(
                    new BufferedInputStream(stream),
                    "application/rtf"
            );
            Log.i("wk", text);
        } catch (UnsupportedMimeTypeException | PlainTextExtractorException e) {
            e.printStackTrace();
        }
    }
}