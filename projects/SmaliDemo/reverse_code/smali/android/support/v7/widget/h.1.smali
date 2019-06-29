.class Landroid/support/v7/widget/h;
.super Landroid/support/v7/widget/P;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/g$d;-><init>(Landroid/support/v7/widget/g;Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic j:Landroid/support/v7/widget/g;

.field final synthetic k:Landroid/support/v7/widget/g$d;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/g$d;Landroid/view/View;Landroid/support/v7/widget/g;)V
    .locals 0
    .param p1, "this$1"    # Landroid/support/v7/widget/g$d;
    .param p2, "src"    # Landroid/view/View;

    .line 652
    iput-object p1, p0, Landroid/support/v7/widget/h;->k:Landroid/support/v7/widget/g$d;

    iput-object p3, p0, Landroid/support/v7/widget/h;->j:Landroid/support/v7/widget/g;

    invoke-direct {p0, p2}, Landroid/support/v7/widget/P;-><init>(Landroid/view/View;)V

    return-void
.end method


# virtual methods
.method public a()Landroid/support/v7/view/menu/z;
    .locals 1

    .line 655
    iget-object v0, p0, Landroid/support/v7/widget/h;->k:Landroid/support/v7/widget/g$d;

    iget-object v0, v0, Landroid/support/v7/widget/g$d;->d:Landroid/support/v7/widget/g;

    iget-object v0, v0, Landroid/support/v7/widget/g;->z:Landroid/support/v7/widget/g$e;

    if-nez v0, :cond_0

    .line 656
    const/4 v0, 0x0

    return-object v0

    .line 659
    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/view/menu/u;->b()Landroid/support/v7/view/menu/s;

    move-result-object v0

    return-object v0
.end method

.method public b()Z
    .locals 1

    .line 664
    iget-object v0, p0, Landroid/support/v7/widget/h;->k:Landroid/support/v7/widget/g$d;

    iget-object v0, v0, Landroid/support/v7/widget/g$d;->d:Landroid/support/v7/widget/g;

    invoke-virtual {v0}, Landroid/support/v7/widget/g;->i()Z

    .line 665
    const/4 v0, 0x1

    return v0
.end method

.method public c()Z
    .locals 2

    .line 673
    iget-object v0, p0, Landroid/support/v7/widget/h;->k:Landroid/support/v7/widget/g$d;

    iget-object v0, v0, Landroid/support/v7/widget/g$d;->d:Landroid/support/v7/widget/g;

    iget-object v1, v0, Landroid/support/v7/widget/g;->B:Landroid/support/v7/widget/g$c;

    if-eqz v1, :cond_0

    .line 674
    const/4 v0, 0x0

    return v0

    .line 677
    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/widget/g;->e()Z

    .line 678
    const/4 v0, 0x1

    return v0
.end method
