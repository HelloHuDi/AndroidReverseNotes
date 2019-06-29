.class Landroid/support/v7/view/menu/e;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/view/menu/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/view/menu/i;


# direct methods
.method constructor <init>(Landroid/support/v7/view/menu/i;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/view/menu/i;

    .line 98
    iput-object p1, p0, Landroid/support/v7/view/menu/e;->a:Landroid/support/v7/view/menu/i;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 4

    .line 104
    iget-object v0, p0, Landroid/support/v7/view/menu/e;->a:Landroid/support/v7/view/menu/i;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/i;->b()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroid/support/v7/view/menu/e;->a:Landroid/support/v7/view/menu/i;

    iget-object v0, v0, Landroid/support/v7/view/menu/i;->j:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    iget-object v0, p0, Landroid/support/v7/view/menu/e;->a:Landroid/support/v7/view/menu/i;

    iget-object v0, v0, Landroid/support/v7/view/menu/i;->j:Ljava/util/List;

    const/4 v1, 0x0

    .line 105
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/view/menu/i$a;

    iget-object v0, v0, Landroid/support/v7/view/menu/i$a;->a:Landroid/support/v7/widget/W;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->k()Z

    move-result v0

    if-nez v0, :cond_2

    .line 106
    iget-object v0, p0, Landroid/support/v7/view/menu/e;->a:Landroid/support/v7/view/menu/i;

    iget-object v0, v0, Landroid/support/v7/view/menu/i;->q:Landroid/view/View;

    .line 107
    .local v0, "anchor":Landroid/view/View;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/view/View;->isShown()Z

    move-result v1

    if-nez v1, :cond_0

    goto :goto_1

    .line 111
    :cond_0
    iget-object v1, p0, Landroid/support/v7/view/menu/e;->a:Landroid/support/v7/view/menu/i;

    iget-object v1, v1, Landroid/support/v7/view/menu/i;->j:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/i$a;

    .line 112
    .local v2, "info":Landroid/support/v7/view/menu/i$a;
    iget-object v3, v2, Landroid/support/v7/view/menu/i$a;->a:Landroid/support/v7/widget/W;

    invoke-virtual {v3}, Landroid/support/v7/widget/U;->c()V

    .line 113
    .end local v2    # "info":Landroid/support/v7/view/menu/i$a;
    goto :goto_0

    .line 108
    :cond_1
    :goto_1
    iget-object v1, p0, Landroid/support/v7/view/menu/e;->a:Landroid/support/v7/view/menu/i;

    invoke-virtual {v1}, Landroid/support/v7/view/menu/i;->dismiss()V

    .line 116
    .end local v0    # "anchor":Landroid/view/View;
    :cond_2
    return-void
.end method
