.class Landroid/support/v7/app/v;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/app/x;->b(La/b/d/d/b$a;)La/b/d/d/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/x;


# direct methods
.method constructor <init>(Landroid/support/v7/app/x;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/x;

    .line 991
    iput-object p1, p0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 994
    iget-object v0, p0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    iget-object v1, v0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/4 v2, 0x0

    const/16 v3, 0x37

    invoke-virtual {v1, v0, v3, v2, v2}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    .line 997
    iget-object v0, p0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    invoke-virtual {v0}, Landroid/support/v7/app/x;->l()V

    .line 999
    iget-object v0, p0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    invoke-virtual {v0}, Landroid/support/v7/app/x;->s()Z

    move-result v0

    const/high16 v1, 0x3f800000    # 1.0f

    if-eqz v0, :cond_0

    .line 1000
    iget-object v0, p0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setAlpha(F)V

    .line 1001
    iget-object v0, p0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    iget-object v2, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-static {v2}, La/b/c/g/u;->a(Landroid/view/View;)La/b/c/g/A;

    move-result-object v2

    invoke-virtual {v2, v1}, La/b/c/g/A;->a(F)La/b/c/g/A;

    iput-object v2, v0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    .line 1002
    iget-object v0, p0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    new-instance v1, Landroid/support/v7/app/u;

    invoke-direct {v1, p0}, Landroid/support/v7/app/u;-><init>(Landroid/support/v7/app/v;)V

    invoke-virtual {v0, v1}, La/b/c/g/A;->a(La/b/c/g/B;)La/b/c/g/A;

    goto :goto_0

    .line 1016
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setAlpha(F)V

    .line 1017
    iget-object v0, p0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/ActionBarContextView;->setVisibility(I)V

    .line 1019
    :goto_0
    return-void
.end method
