.class Landroid/support/v7/widget/U$e;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/U;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "e"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/U;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/U;)V
    .locals 0

    .line 1351
    iput-object p1, p0, Landroid/support/v7/widget/U$e;->a:Landroid/support/v7/widget/U;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1352
    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 1356
    iget-object v0, p0, Landroid/support/v7/widget/U$e;->a:Landroid/support/v7/widget/U;

    iget-object v0, v0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    if-eqz v0, :cond_0

    invoke-static {v0}, La/b/c/g/u;->j(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/U$e;->a:Landroid/support/v7/widget/U;

    iget-object v0, v0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    .line 1357
    invoke-virtual {v0}, Landroid/widget/ListView;->getCount()I

    move-result v0

    iget-object v1, p0, Landroid/support/v7/widget/U$e;->a:Landroid/support/v7/widget/U;

    iget-object v1, v1, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    invoke-virtual {v1}, Landroid/widget/ListView;->getChildCount()I

    move-result v1

    if-le v0, v1, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/U$e;->a:Landroid/support/v7/widget/U;

    iget-object v0, v0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    .line 1358
    invoke-virtual {v0}, Landroid/widget/ListView;->getChildCount()I

    move-result v0

    iget-object v1, p0, Landroid/support/v7/widget/U$e;->a:Landroid/support/v7/widget/U;

    iget v2, v1, Landroid/support/v7/widget/U;->s:I

    if-gt v0, v2, :cond_0

    .line 1359
    iget-object v0, v1, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setInputMethodMode(I)V

    .line 1360
    iget-object v0, p0, Landroid/support/v7/widget/U$e;->a:Landroid/support/v7/widget/U;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->c()V

    .line 1362
    :cond_0
    return-void
.end method
