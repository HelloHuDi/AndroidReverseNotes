.class Landroid/support/v7/app/x$b;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/d/d/b$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/x;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "b"
.end annotation


# instance fields
.field private a:La/b/d/d/b$a;

.field final synthetic b:Landroid/support/v7/app/x;


# direct methods
.method public constructor <init>(Landroid/support/v7/app/x;La/b/d/d/b$a;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/x;
    .param p2, "wrapped"    # La/b/d/d/b$a;

    .line 2155
    iput-object p1, p0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2156
    iput-object p2, p0, Landroid/support/v7/app/x$b;->a:La/b/d/d/b$a;

    .line 2157
    return-void
.end method


# virtual methods
.method public a(La/b/d/d/b;)V
    .locals 3
    .param p1, "mode"    # La/b/d/d/b;

    .line 2176
    iget-object v0, p0, Landroid/support/v7/app/x$b;->a:La/b/d/d/b$a;

    invoke-interface {v0, p1}, La/b/d/d/b$a;->a(La/b/d/d/b;)V

    .line 2177
    iget-object v0, p0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v1, v0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    if-eqz v1, :cond_0

    .line 2178
    iget-object v0, v0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v1, v1, Landroid/support/v7/app/x;->s:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 2181
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v1, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    if-eqz v1, :cond_1

    .line 2182
    invoke-virtual {v0}, Landroid/support/v7/app/x;->l()V

    .line 2183
    iget-object v0, p0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v1, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-static {v1}, La/b/c/g/u;->a(Landroid/view/View;)La/b/c/g/A;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, La/b/c/g/A;->a(F)La/b/c/g/A;

    iput-object v1, v0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    .line 2184
    iget-object v0, p0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    new-instance v1, Landroid/support/v7/app/y;

    invoke-direct {v1, p0}, Landroid/support/v7/app/y;-><init>(Landroid/support/v7/app/x$b;)V

    invoke-virtual {v0, v1}, La/b/c/g/A;->a(La/b/c/g/B;)La/b/c/g/A;

    .line 2199
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    iget-object v1, v0, Landroid/support/v7/app/x;->i:Landroid/support/v7/app/n;

    if-eqz v1, :cond_2

    .line 2200
    iget-object v0, v0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    invoke-interface {v1, v0}, Landroid/support/v7/app/n;->a(La/b/d/d/b;)V

    .line 2202
    :cond_2
    iget-object v0, p0, Landroid/support/v7/app/x$b;->b:Landroid/support/v7/app/x;

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    .line 2203
    return-void
.end method

.method public a(La/b/d/d/b;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "mode"    # La/b/d/d/b;
    .param p2, "menu"    # Landroid/view/Menu;

    .line 2161
    iget-object v0, p0, Landroid/support/v7/app/x$b;->a:La/b/d/d/b$a;

    invoke-interface {v0, p1, p2}, La/b/d/d/b$a;->a(La/b/d/d/b;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public a(La/b/d/d/b;Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "mode"    # La/b/d/d/b;
    .param p2, "item"    # Landroid/view/MenuItem;

    .line 2171
    iget-object v0, p0, Landroid/support/v7/app/x$b;->a:La/b/d/d/b$a;

    invoke-interface {v0, p1, p2}, La/b/d/d/b$a;->a(La/b/d/d/b;Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public b(La/b/d/d/b;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "mode"    # La/b/d/d/b;
    .param p2, "menu"    # Landroid/view/Menu;

    .line 2166
    iget-object v0, p0, Landroid/support/v7/app/x$b;->a:La/b/d/d/b$a;

    invoke-interface {v0, p1, p2}, La/b/d/d/b$a;->b(La/b/d/d/b;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method
