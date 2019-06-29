.class Landroid/support/v7/app/y;
.super La/b/c/g/C;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/app/x$b;->a(La/b/d/d/b;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/x$b;


# direct methods
.method constructor <init>(Landroid/support/v7/app/x$b;)V
    .locals 0
    .param p1, "this$1"    # Landroid/support/v7/app/x$b;

    .line 2184
    iput-object p1, p0, Landroid/support/v7/app/y;->a:Landroid/support/v7/app/x$b;

    invoke-direct {p0}, La/b/c/g/C;-><init>()V

    return-void
.end method


# virtual methods
.method public b(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 2187
    iget-object v0, p0, Landroid/support/v7/app/y;->a:Landroid/support/v7/app/x$b;

    iget-object v0, v0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionBarContextView;->setVisibility(I)V

    .line 2188
    iget-object v0, p0, Landroid/support/v7/app/y;->a:Landroid/support/v7/app/x$b;

    iget-object v0, v0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v1, v0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    if-eqz v1, :cond_0

    .line 2189
    invoke-virtual {v1}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0

    .line 2190
    :cond_0
    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    instance-of v0, v0, Landroid/view/View;

    if-eqz v0, :cond_1

    .line 2191
    iget-object v0, p0, Landroid/support/v7/app/y;->a:Landroid/support/v7/app/x$b;

    iget-object v0, v0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-static {v0}, La/b/c/g/u;->m(Landroid/view/View;)V

    .line 2193
    :cond_1
    :goto_0
    iget-object v0, p0, Landroid/support/v7/app/y;->a:Landroid/support/v7/app/x$b;

    iget-object v0, v0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 2194
    iget-object v0, p0, Landroid/support/v7/app/y;->a:Landroid/support/v7/app/x$b;

    iget-object v0, v0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, La/b/c/g/A;->a(La/b/c/g/B;)La/b/c/g/A;

    .line 2195
    iget-object v0, p0, Landroid/support/v7/app/y;->a:Landroid/support/v7/app/x$b;

    iget-object v0, v0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iput-object v1, v0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    .line 2196
    return-void
.end method
