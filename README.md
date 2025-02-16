# ArcSeekBar

[![Download](https://img.shields.io/badge/download-App-blue.svg)](https://raw.githubusercontent.com/jenly1314/ArcSeekBar/master/app/release/app-release.apk)
[![MavenCentral](https://img.shields.io/maven-central/v/com.github.jenly1314/arcseekbar)](https://repo1.maven.org/maven2/com/github/jenly1314/arcseekbar)
[![JitPack](https://jitpack.io/v/jenly1314/ArcSeekBar.svg)](https://jitpack.io/#jenly1314/ArcSeekBar)
[![CircleCI](https://circleci.com/gh/jenly1314/ArcSeekBar.svg?style=svg)](https://circleci.com/gh/jenly1314/ArcSeekBar)
[![API](https://img.shields.io/badge/API-16%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/mit-license.php)

ArcSeekBar for Android 是一个弧形的拖动条进度控件，配置参数完全可定制化。

**ArcSeekBar** 是基于 [CircleProgressView](https://github.com/jenly1314/CircleProgressView) 修改而来的库。
但青出于蓝而胜于蓝，所以 [CircleProgressView](https://github.com/jenly1314/CircleProgressView) 的大部分用法，**ArcSeekBar** 基本都支持，而且 **ArcSeekBar** 支持的功能点更多，可配置的参数更细致。

> 之所以创建一个 **ArcSeekBar** 而非直接修改 **CircleProgressView** ，主要是因为 **CircleProgressView** 中并不涉及 SeekBar 的场景。
> 还有一个原因是 **ArcSeekBar** 和 **CircleProgressView** 的实现效果存在不同点；至于到底应该用 **CircleProgressView** 还是 **ArcSeekBar**，你可以根据需要去选择更符合自己需求的。

## Gif 展示
![Image](GIF.gif)

> 你也可以直接下载 [演示App](https://raw.githubusercontent.com/jenly1314/ArcSeekBar/master/app/release/app-release.apk) 体验效果

## 引入

### Gradle:
1. 在Project的 **build.gradle** 或 **setting.gradle** 中添加远程仓库

    ```gradle
    repositories {
        //...
        mavenCentral()
    }
    ```

2. 在Module的 **build.gradle** 里面添加引入依赖项
   ```gradle
   implementation 'com.github.jenly1314:arcseekbar:1.2.0'
   ```

## 使用

### ArcSeekBar自定义属性说明（进度默认为渐变色）
| 属性                     | 值类型 | 默认值                                  | 说明                                                             |
|:-----------------------| :------ |:-------------------------------------|:---------------------------------------------------------------|
| ~~arcStrokeWidth~~     | dimension | 12dp                                 | 画笔描边的宽度（已废弃，改用`arcNormalStrokeWidth`和`arcProgressStrokeWidth`） |
| arcNormalStrokeWidth   | dimension | 12dp                                 | 弧形正常画笔描边的宽度（v1.2.0新增）                                          |
| arcProgressStrokeWidth | dimension | 12dp                                 | 弧形进度条画笔描边的宽度（v1.2.0新增）                                         |
| arcStrokeCap           | enum | ROUND                                | 画笔的线冒样式                                                        |
| arcNormalColor         | color | <font color=#C8C8C8>#FFC8C8C8</font> | 弧形正常颜色                                                         |
| arcProgressColor       | color | <font color=#4FEAAC>#FF4FEAAC</font> | 弧形进度颜色                                                         |
| arcStartAngle          | integer | 270                                  | 开始角度，默认十二点钟方向                                                  |
| arcSweepAngle          | integer | 360                                  | 扫描角度范围                                                         |
| arcMax                 | integer | 100                                  | 进度最大值                                                          |
| arcProgress            | integer | 0                                    | 当前进度                                                           |
| arcDuration            | integer | 500                                  | 动画时长                                                           |
| arcLabelText           | string |                                      | 中间的标签文本，默认自动显示百分比                                              |
| arcLabelTextColor      | color | <font color=#333333>#FF333333</font> | 文本字体颜色                                                         |
| arcLabelTextSize       | dimension | 30sp                                 | 文本字体大小                                                         |
| arcLabelPaddingTop     | dimension | 0dp                                  | 文本居顶边内间距                                                       |
| arcLabelPaddingBottom  | dimension | 0dp                                  | 文本居底边内间距                                                       |
| arcLabelPaddingLeft    | dimension | 0dp                                  | 文本居左边内间距                                                       |
| arcLabelPaddingRight   | dimension | 0dp                                  | 文本居右边内间距                                                       |
| arcShowLabel           | boolean | true                                 | 是否显示文本                                                         |
| arcShowTick            | boolean | true                                 | 是否显示环刻度                                                        |
| arcTickStrokeWidth     | dimension | 10dp                                 | 刻度画笔宽度                                                         |
| arcTickPadding         | dimension | 2dp                                  | 环刻度与环间距                                                        |
| arcTickSplitAngle      | integer | 5                                    | 刻度间隔的角度大小                                                      |
| arcBlockAngle          | integer | 1                                    | 刻度的角度大小                                                        |
| arcTickOffsetAngle     | integer | 0                                    | 刻度偏移的角度大小                                                      |
| arcThumbStrokeWidth    | dimension | 10dp                                 | 拖动按钮画笔宽度                                                       |
| arcThumbColor          | color | <font color=#E8D30F>#FFE8D30F</font> | 拖动按钮颜色                                                         |
| arcThumbRadius         | dimension | 8dp                                  | 拖动按钮半径                                                         |
| arcThumbRadiusEnlarges | dimension | 2dp                                  | 触摸时按钮半径放大量                                                     |
| arcShowThumb           | boolean | true                                 | 是否显示拖动按钮                                                       |
| arcThumbDrawable       | reference |                                      | 拖动按钮图片（arcThumbDrawable的优先级高于arcThumbColor）                    |
| arcAllowableOffsets    | dimension | 10dp                                 | 触摸时可偏移距离：偏移量越大，触摸精度越小                                          |
| arcEnabledDrag         | boolean | true                                 | 是否启用通过拖动改变进度                                                   |
| arcEnabledSingle       | boolean | true                                 | 是否启用通过点击改变进度                                                   |


### 示例

布局示例
```Xml
    <com.king.view.arcseekbar.ArcSeekBar
        android:id="@+id/arcSeekBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:arcEnabledDrag="true"/>
```

代码示例
```Java
    // 进度改变监听
    arcSeekBar.setOnChangeListener(listener);

    // 设置进度颜色；传多个颜色时则表示为渐变色（设置渐变色时尽量保证首尾同色）
    arcSeekBar.setProgressColor(color);

    // 设置进度
    arcSeekBar.setProgress(progress);

    // 显示进度动画（进度，动画时长）
    arcSeekBar.showAnimation(80,3000);


```
更多使用详情，请查看[app](app)中的源码使用示例或直接查看 [API帮助文档](https://jenly1314.github.io/ArcSeekBar/api/)

## 相关推荐

- [CircleProgressView](https://github.com/jenly1314/CircleProgressView) 一个圆形的进度动画控件，动画效果纵享丝滑。
- [SpinCounterView](https://github.com/jenly1314/SpinCounterView) 一个类似码表变化的旋转计数器动画控件。
- [RadarView](https://github.com/jenly1314/RadarView) 一个雷达扫描动画后，然后展示得分效果的控件。

<!-- end -->

## 版本日志

#### v1.2.0 2025-2-7
*  新增属性：`arcNormalStrokeWidth` 和 `arcProgressStrokeWidth`（废弃属性：`arcStrokeWidth`）
*  修复BUG：最大值多次动态变化后，会影响到进度拖动问题。（[#14](https://github.com/jenly1314/ArcSeekBar/issues/14)）
*  优化细节

#### [查看更多版本日志](CHANGELOG.md)

## 赞赏
如果您喜欢ArcSeekBar，或感觉ArcSeekBar帮助到了您，可以点右上角“Star”支持一下，您的支持就是我的动力，谢谢 :smiley:
<p>您也可以扫描下面的二维码，请作者喝杯咖啡 :coffee:

<div>
   <img src="https://jenly1314.github.io/image/page/rewardcode.png">
</div>

## 关于我

| 我的博客                                                                                | GitHub                                                                                  | Gitee                                                                                  | CSDN                                                                                 | 博客园                                                                            |
|:------------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------|
| <a title="我的博客" href="https://jenly1314.github.io" target="_blank">Jenly's Blog</a> | <a title="GitHub开源项目" href="https://github.com/jenly1314" target="_blank">jenly1314</a> | <a title="Gitee开源项目" href="https://gitee.com/jenly1314" target="_blank">jenly1314</a>  | <a title="CSDN博客" href="http://blog.csdn.net/jenly121" target="_blank">jenly121</a>  | <a title="博客园" href="https://www.cnblogs.com/jenly" target="_blank">jenly</a>  |

## 联系我

| 微信公众号        | Gmail邮箱                                                                          | QQ邮箱                                                                              | QQ群                                                                                                                       | QQ群                                                                                                                       |
|:-------------|:---------------------------------------------------------------------------------|:----------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------|
| [Jenly666](http://weixin.qq.com/r/wzpWTuPEQL4-ract92-R) | <a title="给我发邮件" href="mailto:jenly1314@gmail.com" target="_blank">jenly1314</a> | <a title="给我发邮件" href="mailto:jenly1314@vip.qq.com" target="_blank">jenly1314</a> | <a title="点击加入QQ群" href="https://qm.qq.com/cgi-bin/qm/qr?k=6_RukjAhwjAdDHEk2G7nph-o8fBFFzZz" target="_blank">20867961</a> | <a title="点击加入QQ群" href="https://qm.qq.com/cgi-bin/qm/qr?k=Z9pobM8bzAW7tM_8xC31W8IcbIl0A-zT" target="_blank">64020761</a> |

<div>
   <img src="https://jenly1314.github.io/image/page/footer.png">
</div>
