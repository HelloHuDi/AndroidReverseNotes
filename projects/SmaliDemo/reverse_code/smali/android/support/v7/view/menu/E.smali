.class Landroid/support/v7/view/menu/E;
.super Landroid/support/v7/view/menu/y;
.source ""

# interfaces
.implements Landroid/view/SubMenu;


# direct methods
.method constructor <init>(Landroid/content/Context;La/b/c/c/a/c;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "subMenu"    # La/b/c/c/a/c;

    .line 38
    invoke-direct {p0, p1, p2}, Landroid/support/v7/view/menu/y;-><init>(Landroid/content/Context;La/b/c/c/a/a;)V

    .line 39
    return-void
.end method


# virtual methods
.method public c()La/b/c/c/a/c;
    .locals 1

    .line 43
    iget-object v0, p0, Landroid/support/v7/view/menu/d;->a:Ljava/lang/Object;

    check-cast v0, La/b/c/c/a/c;

    return-object v0
.end method

.method public clearHeader()V
    .locals 1

    .line 78
    invoke-virtual {p0}, Landroid/support/v7/view/menu/E;->c()La/b/c/c/a/c;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/SubMenu;->clearHeader()V

    .line 79
    return-void
.end method

.method public getItem()Landroid/view/MenuItem;
    .locals 1

    .line 95
    invoke-virtual {p0}, Landroid/support/v7/view/menu/E;->c()La/b/c/c/a/c;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/SubMenu;->getItem()Landroid/view/MenuItem;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/c;->a(Landroid/view/MenuItem;)Landroid/view/MenuItem;

    move-result-object v0

    return-object v0
.end method

.method public setHeaderIcon(I)Landroid/view/SubMenu;
    .locals 1
    .param p1, "iconRes"    # I

    .line 60
    invoke-virtual {p0}, Landroid/support/v7/view/menu/E;->c()La/b/c/c/a/c;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/SubMenu;->setHeaderIcon(I)Landroid/view/SubMenu;

    .line 61
    return-object p0
.end method

.method public setHeaderIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/SubMenu;
    .locals 1
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .line 66
    invoke-virtual {p0}, Landroid/support/v7/view/menu/E;->c()La/b/c/c/a/c;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/SubMenu;->setHeaderIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/SubMenu;

    .line 67
    return-object p0
.end method

.method public setHeaderTitle(I)Landroid/view/SubMenu;
    .locals 1
    .param p1, "titleRes"    # I

    .line 48
    invoke-virtual {p0}, Landroid/support/v7/view/menu/E;->c()La/b/c/c/a/c;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/SubMenu;->setHeaderTitle(I)Landroid/view/SubMenu;

    .line 49
    return-object p0
.end method

.method public setHeaderTitle(Ljava/lang/CharSequence;)Landroid/view/SubMenu;
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 54
    invoke-virtual {p0}, Landroid/support/v7/view/menu/E;->c()La/b/c/c/a/c;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/SubMenu;->setHeaderTitle(Ljava/lang/CharSequence;)Landroid/view/SubMenu;

    .line 55
    return-object p0
.end method

.method public setHeaderView(Landroid/view/View;)Landroid/view/SubMenu;
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 72
    invoke-virtual {p0}, Landroid/support/v7/view/menu/E;->c()La/b/c/c/a/c;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/SubMenu;->setHeaderView(Landroid/view/View;)Landroid/view/SubMenu;

    .line 73
    return-object p0
.end method

.method public setIcon(I)Landroid/view/SubMenu;
    .locals 1
    .param p1, "iconRes"    # I

    .line 83
    invoke-virtual {p0}, Landroid/support/v7/view/menu/E;->c()La/b/c/c/a/c;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/SubMenu;->setIcon(I)Landroid/view/SubMenu;

    .line 84
    return-object p0
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/SubMenu;
    .locals 1
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .line 89
    invoke-virtual {p0}, Landroid/support/v7/view/menu/E;->c()La/b/c/c/a/c;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/SubMenu;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/SubMenu;

    .line 90
    return-object p0
.end method
