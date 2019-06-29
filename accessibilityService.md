**[AccessibilityService是什么？](https://developer.android.google.cn/reference/kotlin/android/accessibilityservice/package-summary?hl=en)**

**Accessibility services should only be used to assist users with disabilities in using Android devices and apps.**

**AccessibilityService出现的本意是作为辅助功能帮助残障人士更好更方便的使用我们的Android，可惜它被带跑偏了~~**

**AccessibilityService外部的工作原理是通过自带API接收外部给定的目标(文本，资源id...)来查询目标控件，并模拟(触摸，点击，长按...)操作来触发事件**

**AccessibilityService可以做什么了？做外挂！比如微信红包外挂，游戏操作外挂(神一样的反应速度，让你无懈可击~~~)**

**想要AccessibilityService应用工作正常情况下需要用户同意你的操作请求，所以是个显示的操作，不过如果能与Xposed结合，或许就可以静悄悄的干活了~~**




