.class public La/b/d/d/f;
.super Landroid/view/ActionMode;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        La/b/d/d/f$a;
    }
.end annotation


# instance fields
.field final a:Landroid/content/Context;

.field final b:La/b/d/d/b;


# direct methods
.method public constructor <init>(Landroid/content/Context;La/b/d/d/b;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "supportActionMode"    # La/b/d/d/b;

    .line 48
    invoke-direct {p0}, Landroid/view/ActionMode;-><init>()V

    .line 49
    iput-object p1, p0, La/b/d/d/f;->a:Landroid/content/Context;

    .line 50
    iput-object p2, p0, La/b/d/d/f;->b:La/b/d/d/b;

    .line 51
    return-void
.end method


# virtual methods
.method public finish()V
    .locals 1

    .line 80
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0}, La/b/d/d/b;->a()V

    .line 81
    return-void
.end method

.method public getCustomView()Landroid/view/View;
    .locals 1

    .line 110
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0}, La/b/d/d/b;->b()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getMenu()Landroid/view/Menu;
    .locals 2

    .line 85
    iget-object v0, p0, La/b/d/d/f;->a:Landroid/content/Context;

    iget-object v1, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v1}, La/b/d/d/b;->c()Landroid/view/Menu;

    move-result-object v1

    check-cast v1, La/b/c/c/a/a;

    invoke-static {v0, v1}, Landroid/support/v7/view/menu/x;->a(Landroid/content/Context;La/b/c/c/a/a;)Landroid/view/Menu;

    move-result-object v0

    return-object v0
.end method

.method public getMenuInflater()Landroid/view/MenuInflater;
    .locals 1

    .line 120
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0}, La/b/d/d/b;->d()Landroid/view/MenuInflater;

    move-result-object v0

    return-object v0
.end method

.method public getSubtitle()Ljava/lang/CharSequence;
    .locals 1

    .line 100
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0}, La/b/d/d/b;->e()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getTag()Ljava/lang/Object;
    .locals 1

    .line 55
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0}, La/b/d/d/b;->f()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 1

    .line 90
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0}, La/b/d/d/b;->g()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getTitleOptionalHint()Z
    .locals 1

    .line 125
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0}, La/b/d/d/b;->h()Z

    move-result v0

    return v0
.end method

.method public invalidate()V
    .locals 1

    .line 75
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0}, La/b/d/d/b;->i()V

    .line 76
    return-void
.end method

.method public isTitleOptional()Z
    .locals 1

    .line 135
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0}, La/b/d/d/b;->j()Z

    move-result v0

    return v0
.end method

.method public setCustomView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 115
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0, p1}, La/b/d/d/b;->a(Landroid/view/View;)V

    .line 116
    return-void
.end method

.method public setSubtitle(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 105
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0, p1}, La/b/d/d/b;->a(I)V

    .line 106
    return-void
.end method

.method public setSubtitle(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "subtitle"    # Ljava/lang/CharSequence;

    .line 70
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0, p1}, La/b/d/d/b;->a(Ljava/lang/CharSequence;)V

    .line 71
    return-void
.end method

.method public setTag(Ljava/lang/Object;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/Object;

    .line 60
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0, p1}, La/b/d/d/b;->a(Ljava/lang/Object;)V

    .line 61
    return-void
.end method

.method public setTitle(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 95
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0, p1}, La/b/d/d/b;->b(I)V

    .line 96
    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 65
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0, p1}, La/b/d/d/b;->b(Ljava/lang/CharSequence;)V

    .line 66
    return-void
.end method

.method public setTitleOptionalHint(Z)V
    .locals 1
    .param p1, "titleOptional"    # Z

    .line 130
    iget-object v0, p0, La/b/d/d/f;->b:La/b/d/d/b;

    invoke-virtual {v0, p1}, La/b/d/d/b;->a(Z)V

    .line 131
    return-void
.end method
