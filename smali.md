**JAVA和Smali数据类型对比**

| smali | java |
|:------:|:------:|
|  V   | void |
|  Z   | boolean |
|  B   | byte |
|  S   | short |
|  C   | char |
|  I   | int |
|  J   | long |
|  F   | float |
|  D   | double |
|  L   | 对象 |
|  [   | 数组 |

**语法**

| smali | meaning |
|:------:|:------:|
|.field |　定义变量 |
|.method　|　方法 |
|.parameter　|　方法参数 |
|.prologue　|　方法开始 |
|.line 12　|　此方法位于第12行 |
|invoke-super　|　调用父函数 |
|const/high16  v0, 0x7fo3　|　把0x7fo3赋值给v0 |
|invoke-direct　|　调用函数 |
|return-void　|　函数返回void |
|.end method　|　函数结束 |
|new-instance　|　创建实例 |
|iput-object　|　对象赋值 |
|iget-object　|　调用对象 |
|invoke-static　|　调用静态函数 |

**smali跳转语句**

```
“if-eq vA, vB, :cond_**” 如果vA等于vB则跳转到:cond_**

“if-ne vA, vB, :cond_**” 如果vA不等于vB则跳转到:cond_**

“if-lt vA, vB, :cond_**” 如果vA小于vB则跳转到:cond_**

“if-ge vA, vB, :cond_**” 如果vA大于等于vB则跳转到:cond_**

“if-gt vA, vB, :cond_**” 如果vA大于vB则跳转到:cond_**

“if-le vA, vB, :cond_**” 如果vA小于等于vB则跳转到:cond_**

“if-eqz vA, :cond_**” 如果vA等于0则跳转到:cond_**

“if-nez vA, :cond_**” 如果vA不等于0则跳转到:cond_**

“if-ltz vA, :cond_**” 如果vA小于0则跳转到:cond_**

“if-gez vA, :cond_**” 如果vA大于等于0则跳转到:cond_**

“if-gtz vA, :cond_**” 如果vA大于0则跳转到:cond_**

“if-lez vA, :cond_**” 如果vA小于等于0则跳转到:cond_**
```

**更多资料**

[smali纯英语手册pdf版](docs/smali_dalvik_opcodes.pdf)

http://blog.csdn.net/lostinai/article/details/48975661

http://blog.csdn.net/sjim_/article/details/50443860

https://blog.csdn.net/jimmy5z/article/details/12119739



