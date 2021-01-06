# RtfParser
📄 Parse Rich Text Format Doc [![](https://jitpack.io/v/book-note/RtfParser.svg)](https://jitpack.io/#book-note/RtfParser)
## How to
### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### Step 2. Add the dependency
```
	dependencies {
	        implementation 'com.github.book-note:RtfParser:Tag'
	}
```
### Step 3. Use in your code
```
        String demo = "{\\rtf1\\ansi\\ansicpg936\\cocoartf2576\n" +
                "\\cocoatextscaling0\\cocoaplatform0{\\fonttbl\\f0\\fswiss\\fcharset0 Helvetica;}\n" +
                "{\\colortbl;\\red255\\green255\\blue255;\\red254\\green207\\blue137;\\red255\\green235\\blue127;}\n" +
                "{\\*\\expandedcolortbl;;\\cssrgb\\c100000\\c84314\\c60392;\\cssrgb\\c100000\\c92941\\c56863;}\n" +
                "\\pard\\tx560\\tx1120\\tx1680\\tx2240\\tx2800\\tx3360\\tx3920\\tx4480\\tx5040\\tx5600\\tx6160\\tx6720\\pardirnatural\\partightenfactor0\n" +
                "\n}";
        InputStream stream = new ByteArrayInputStream(demo.getBytes(StandardCharsets.UTF_8));
        PlainTextExtractor extractor = new PlainTextExtractor();
        String text = extractor.extract(
                new BufferedInputStream(stream),
                "application/rtf"
        );
        Log.i("wk", text);
```
❤️ based on: https://github.com/ranaparamveer/RTF-Parser 

