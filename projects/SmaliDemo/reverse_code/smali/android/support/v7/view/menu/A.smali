.class Landroid/support/v7/view/menu/A;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/view/menu/C;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/view/menu/C;


# direct methods
.method constructor <init>(Landroid/support/v7/view/menu/C;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/view/menu/C;

    .line 61
    iput-object p1, p0, Landroid/support/v7/view/menu/A;->a:Landroid/support/v7/view/menu/C;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 2

    .line 67
    iget-object v0, p0, Landroid/support/v7/view/menu/A;->a:Landroid/support/v7/view/menu/C;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/C;->b()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroid/support/v7/view/menu/A;->a:Landroid/support/v7/view/menu/C;

    iget-object v0, v0, Landroid/support/v7/view/menu/C;->j:Landroid/support/v7/widget/W;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->k()Z

    move-result v0

    if-nez v0, :cond_2

    .line 68
    iget-object v0, p0, Landroid/support/v7/view/menu/A;->a:Landroid/support/v7/view/menu/C;

    iget-object v0, v0, Landroid/support/v7/view/menu/C;->o:Landroid/view/View;

    .line 69
    .local v0, "anchor":Landroid/view/View;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/view/View;->isShown()Z

    move-result v1

    if-nez v1, :cond_0

    goto :goto_0

    .line 73
    :cond_0
    iget-object v1, p0, Landroid/support/v7/view/menu/A;->a:Landroid/support/v7/view/menu/C;

    iget-object v1, v1, Landroid/support/v7/view/menu/C;->j:Landroid/support/v7/widget/W;

    invoke-virtual {v1}, Landroid/support/v7/widget/U;->c()V

    goto :goto_1

    .line 70
    :cond_1
    :goto_0
    iget-object v1, p0, Landroid/support/v7/view/menu/A;->a:Landroid/support/v7/view/menu/C;

    invoke-virtual {v1}, Landroid/support/v7/view/menu/C;->dismiss()V

    .line 76
    .end local v0    # "anchor":Landroid/view/View;
    :cond_2
    :goto_1
    return-void
.end method
