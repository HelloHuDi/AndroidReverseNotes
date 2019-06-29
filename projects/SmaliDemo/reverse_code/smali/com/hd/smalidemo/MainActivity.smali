.class public Lcom/hd/smalidemo/MainActivity;
.super Landroid/support/v7/app/m;
.source ""

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static p:Z


# instance fields
.field public q:C

.field private r:F

.field private final s:D

.field private final t:S

.field private u:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private v:Landroid/widget/TextView;

.field private w:Landroid/widget/EditText;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 19
    const/4 v0, 0x0

    sput-boolean v0, Lcom/hd/smalidemo/MainActivity;->p:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .line 16
    invoke-direct {p0}, Landroid/support/v7/app/m;-><init>()V

    .line 20
    const/16 v0, 0x61

    iput-char v0, p0, Lcom/hd/smalidemo/MainActivity;->q:C

    .line 21
    const/high16 v0, 0x42080000    # 34.0f

    iput v0, p0, Lcom/hd/smalidemo/MainActivity;->r:F

    .line 22
    const-wide v0, 0x4074e00000000000L    # 334.0

    iput-wide v0, p0, Lcom/hd/smalidemo/MainActivity;->s:D

    .line 23
    const/4 v0, 0x2

    iput-short v0, p0, Lcom/hd/smalidemo/MainActivity;->t:S

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/hd/smalidemo/MainActivity;->u:Ljava/util/List;

    return-void
.end method

.method private l()V
    .locals 7

    .line 56
    sget-boolean v0, Lcom/hd/smalidemo/MainActivity;->p:Z

    const/4 v1, 0x1 

    # 如果不等于0 就跳到 cond_0
    if-eqz v0, :cond_0
     
    .line 57
    const-string v0, "\u6d4b\u8bd5:heh"

    #调用静态方法，传入 vo, v1 即 测试 ，Toast.LENGTH_LONG
    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    #调用 public方法 
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    # 字面意思 跳到 goto_0 标签
    goto :goto_0

    .line 59
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\u6d4b\u8bd5:"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-char v2, p0, Lcom/hd/smalidemo/MainActivity;->q:C

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 61
    :goto_0
    # 调用float 类型 r 
    iget v0, p0, Lcom/hd/smalidemo/MainActivity;->r:F

    # float vo 转换成double v2
    float-to-double v2, v0

    const-wide v4, 0x4074e00000000000L    # 334.0

    const-string v0, "tag"

    # 比较两个双精度浮点数。如果v2小于v4，则v6结果为1，相等则结果为0，大于的话结果为-1
    # 换成java 源文件的意思是 34.f 是否大于 334d
    cmpl-double v6, v2, v4

    # 如果v6小于等于0则跳转到 cond_1
    # 如果34.f大于等于334d就执行 cond_1 后方法， 这里显然会执行后续的   .line 62
    if-lez v6, :cond_1

    .line 62
    const-string v2, "\u5c31\u662f\u8981\u8fd9\u6837\u641e1:2"

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 64
    :cond_1
    iget-char v2, p0, Lcom/hd/smalidemo/MainActivity;->q:C

    # 如果v2不等于v1则跳转到:cond_2
    # v1 前面已经初始化过 ： const/4 v1, 0x1 
    if-ne v2, v1, :cond_2

    .line 65
    const-string v1, "\u5c31\u662f\u8981\u8fd9\u6837\u641e2"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 67
    :cond_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\u5c31\u662f\u8981\u8fd9\u6837\u641e3"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/hd/smalidemo/MainActivity;->u:Ljava/util/List;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    iget-object v0, p0, Lcom/hd/smalidemo/MainActivity;->v:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/hd/smalidemo/MainActivity;->w:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    # 这里把前面转换过的string 类型 v1 填充进vo方法内
    # invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    # 把上面方法注释掉，重新调用我自己定义的变量设置进去，任你前面怎么转换，我不用你～～
    # 把上面这句中文转换成unicode
    const-string v3, "\u628a\u4e0a\u9762\u65b9\u6cd5\u6ce8\u91ca\u6389\uff0c\u91cd\u65b0\u8c03\u7528\u6211\u81ea\u5df1\u5b9a\u4e49\u7684\u53d8\u91cf\u8bbe\u7f6e\u8fdb\u53bb\uff0c\u4efb\u4f60\u524d\u9762\u600e\u4e48\u8f6c\u6362\uff0c\u6211\u4e0d\u7528\u4f60\uff5e\uff5e"
    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 69
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetTextI18n"
        }
    .end annotation

    .line 50
    sget-boolean v0, Lcom/hd/smalidemo/MainActivity;->p:Z

    xor-int/lit8 v0, v0, 0x1

    sput-boolean v0, Lcom/hd/smalidemo/MainActivity;->p:Z

    .line 51
    move-object v0, p1

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\u539f\u5185\u5bb9 \uff1a"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/hd/smalidemo/MainActivity;->w:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 52
    invoke-direct {p0}, Lcom/hd/smalidemo/MainActivity;->l()V

    .line 53
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 30
    invoke-super {p0, p1}, Landroid/support/v7/app/m;->onCreate(Landroid/os/Bundle;)V

    .line 31
    const v0, 0x7f09001c

    invoke-virtual {p0, v0}, Landroid/support/v7/app/m;->setContentView(I)V

    .line 32
    const v0, 0x7f070022

    invoke-virtual {p0, v0}, Landroid/support/v7/app/m;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 33
    const v0, 0x7f07008f

    invoke-virtual {p0, v0}, Landroid/support/v7/app/m;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/hd/smalidemo/MainActivity;->v:Landroid/widget/TextView;

    .line 34
    const v0, 0x7f070038

    invoke-virtual {p0, v0}, Landroid/support/v7/app/m;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/hd/smalidemo/MainActivity;->w:Landroid/widget/EditText;

    .line 35
    return-void
.end method

.method protected onResume()V
    .locals 2

    .line 39
    invoke-super {p0}, Landroid/support/v4/app/k;->onResume()V

    .line 40
    iget-object v0, p0, Lcom/hd/smalidemo/MainActivity;->u:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 41
    iget-object v0, p0, Lcom/hd/smalidemo/MainActivity;->u:Ljava/util/List;

    const-string v1, "a"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 42
    iget-object v0, p0, Lcom/hd/smalidemo/MainActivity;->u:Ljava/util/List;

    const-string v1, "b"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 43
    iget-object v0, p0, Lcom/hd/smalidemo/MainActivity;->u:Ljava/util/List;

    const-string v1, "c"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 44
    iget-object v0, p0, Lcom/hd/smalidemo/MainActivity;->u:Ljava/util/List;

    const-string v1, "d"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 45
    return-void
.end method
