.class public La/b/d/d/e;
.super La/b/d/d/b;
.source ""

# interfaces
.implements Landroid/support/v7/view/menu/l$a;


# instance fields
.field private c:Landroid/content/Context;

.field private d:Landroid/support/v7/widget/ActionBarContextView;

.field private e:La/b/d/d/b$a;

.field private f:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private g:Z

.field private h:Z

.field private i:Landroid/support/v7/view/menu/l;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v7/widget/ActionBarContextView;La/b/d/d/b$a;Z)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "view"    # Landroid/support/v7/widget/ActionBarContextView;
    .param p3, "callback"    # La/b/d/d/b$a;
    .param p4, "isFocusable"    # Z

    .line 50
    invoke-direct {p0}, La/b/d/d/b;-><init>()V

    .line 51
    iput-object p1, p0, La/b/d/d/e;->c:Landroid/content/Context;

    .line 52
    iput-object p2, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    .line 53
    iput-object p3, p0, La/b/d/d/e;->e:La/b/d/d/b$a;

    .line 55
    new-instance v0, Landroid/support/v7/view/menu/l;

    invoke-virtual {p2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/view/menu/l;-><init>(Landroid/content/Context;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/l;->c(I)Landroid/support/v7/view/menu/l;

    iput-object v0, p0, La/b/d/d/e;->i:Landroid/support/v7/view/menu/l;

    .line 57
    iget-object v0, p0, La/b/d/d/e;->i:Landroid/support/v7/view/menu/l;

    invoke-virtual {v0, p0}, Landroid/support/v7/view/menu/l;->a(Landroid/support/v7/view/menu/l$a;)V

    .line 58
    iput-boolean p4, p0, La/b/d/d/e;->h:Z

    .line 59
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .line 105
    iget-boolean v0, p0, La/b/d/d/e;->g:Z

    if-eqz v0, :cond_0

    .line 106
    return-void

    .line 108
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, La/b/d/d/e;->g:Z

    .line 110
    iget-object v0, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->sendAccessibilityEvent(I)V

    .line 111
    iget-object v0, p0, La/b/d/d/e;->e:La/b/d/d/b$a;

    invoke-interface {v0, p0}, La/b/d/d/b$a;->a(La/b/d/d/b;)V

    .line 112
    return-void
.end method

.method public a(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 78
    iget-object v0, p0, La/b/d/d/e;->c:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, La/b/d/d/e;->a(Ljava/lang/CharSequence;)V

    .line 79
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;)V
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;

    .line 161
    invoke-virtual {p0}, La/b/d/d/e;->i()V

    .line 162
    iget-object v0, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionBarContextView;->d()Z

    .line 163
    return-void
.end method

.method public a(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 94
    iget-object v0, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionBarContextView;->setCustomView(Landroid/view/View;)V

    .line 95
    if-eqz p1, :cond_0

    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, La/b/d/d/e;->f:Ljava/lang/ref/WeakReference;

    .line 96
    return-void
.end method

.method public a(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "subtitle"    # Ljava/lang/CharSequence;

    .line 68
    iget-object v0, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionBarContextView;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 69
    return-void
.end method

.method public a(Z)V
    .locals 1
    .param p1, "titleOptional"    # Z

    .line 83
    invoke-super {p0, p1}, La/b/d/d/b;->a(Z)V

    .line 84
    iget-object v0, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionBarContextView;->setTitleOptional(Z)V

    .line 85
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/view/MenuItem;

    .line 141
    iget-object v0, p0, La/b/d/d/e;->e:La/b/d/d/b$a;

    invoke-interface {v0, p0, p2}, La/b/d/d/b$a;->a(La/b/d/d/b;Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public b()Landroid/view/View;
    .locals 1

    .line 131
    iget-object v0, p0, La/b/d/d/e;->f:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public b(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 73
    iget-object v0, p0, La/b/d/d/e;->c:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, La/b/d/d/e;->b(Ljava/lang/CharSequence;)V

    .line 74
    return-void
.end method

.method public b(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 63
    iget-object v0, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionBarContextView;->setTitle(Ljava/lang/CharSequence;)V

    .line 64
    return-void
.end method

.method public c()Landroid/view/Menu;
    .locals 1

    .line 116
    iget-object v0, p0, La/b/d/d/e;->i:Landroid/support/v7/view/menu/l;

    return-object v0
.end method

.method public d()Landroid/view/MenuInflater;
    .locals 2

    .line 136
    new-instance v0, La/b/d/d/g;

    iget-object v1, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, La/b/d/d/g;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public e()Ljava/lang/CharSequence;
    .locals 1

    .line 126
    iget-object v0, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionBarContextView;->getSubtitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public g()Ljava/lang/CharSequence;
    .locals 1

    .line 121
    iget-object v0, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionBarContextView;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public i()V
    .locals 2

    .line 100
    iget-object v0, p0, La/b/d/d/e;->e:La/b/d/d/b$a;

    iget-object v1, p0, La/b/d/d/e;->i:Landroid/support/v7/view/menu/l;

    invoke-interface {v0, p0, v1}, La/b/d/d/b$a;->b(La/b/d/d/b;Landroid/view/Menu;)Z

    .line 101
    return-void
.end method

.method public j()Z
    .locals 1

    .line 89
    iget-object v0, p0, La/b/d/d/e;->d:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionBarContextView;->b()Z

    move-result v0

    return v0
.end method
