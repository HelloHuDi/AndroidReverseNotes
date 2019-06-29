.class Landroid/support/v7/widget/B;
.super Landroid/support/v7/widget/P;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/C;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;IILandroid/content/res/Resources$Theme;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic j:Landroid/support/v7/widget/C$b;

.field final synthetic k:Landroid/support/v7/widget/C;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/C;Landroid/view/View;Landroid/support/v7/widget/C$b;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/C;
    .param p2, "src"    # Landroid/view/View;

    .line 246
    iput-object p1, p0, Landroid/support/v7/widget/B;->k:Landroid/support/v7/widget/C;

    iput-object p3, p0, Landroid/support/v7/widget/B;->j:Landroid/support/v7/widget/C$b;

    invoke-direct {p0, p2}, Landroid/support/v7/widget/P;-><init>(Landroid/view/View;)V

    return-void
.end method


# virtual methods
.method public a()Landroid/support/v7/view/menu/z;
    .locals 1

    .line 249
    iget-object v0, p0, Landroid/support/v7/widget/B;->j:Landroid/support/v7/widget/C$b;

    return-object v0
.end method

.method public b()Z
    .locals 1

    .line 254
    iget-object v0, p0, Landroid/support/v7/widget/B;->k:Landroid/support/v7/widget/C;

    iget-object v0, v0, Landroid/support/v7/widget/C;->g:Landroid/support/v7/widget/C$b;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 255
    iget-object v0, p0, Landroid/support/v7/widget/B;->k:Landroid/support/v7/widget/C;

    iget-object v0, v0, Landroid/support/v7/widget/C;->g:Landroid/support/v7/widget/C$b;

    invoke-virtual {v0}, Landroid/support/v7/widget/C$b;->c()V

    .line 257
    :cond_0
    const/4 v0, 0x1

    return v0
.end method
