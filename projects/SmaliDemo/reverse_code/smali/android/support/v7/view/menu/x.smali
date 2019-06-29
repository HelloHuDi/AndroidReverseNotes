.class public final Landroid/support/v7/view/menu/x;
.super Ljava/lang/Object;
.source ""


# direct methods
.method public static a(Landroid/content/Context;La/b/c/c/a/a;)Landroid/view/Menu;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "supportMenu"    # La/b/c/c/a/a;

    .line 41
    new-instance v0, Landroid/support/v7/view/menu/y;

    invoke-direct {v0, p0, p1}, Landroid/support/v7/view/menu/y;-><init>(Landroid/content/Context;La/b/c/c/a/a;)V

    return-object v0
.end method

.method public static a(Landroid/content/Context;La/b/c/c/a/b;)Landroid/view/MenuItem;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "supportMenuItem"    # La/b/c/c/a/b;

    .line 45
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 46
    new-instance v0, Landroid/support/v7/view/menu/r;

    invoke-direct {v0, p0, p1}, Landroid/support/v7/view/menu/r;-><init>(Landroid/content/Context;La/b/c/c/a/b;)V

    return-object v0

    .line 48
    :cond_0
    new-instance v0, Landroid/support/v7/view/menu/q;

    invoke-direct {v0, p0, p1}, Landroid/support/v7/view/menu/q;-><init>(Landroid/content/Context;La/b/c/c/a/b;)V

    return-object v0
.end method

.method public static a(Landroid/content/Context;La/b/c/c/a/c;)Landroid/view/SubMenu;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "supportSubMenu"    # La/b/c/c/a/c;

    .line 53
    new-instance v0, Landroid/support/v7/view/menu/E;

    invoke-direct {v0, p0, p1}, Landroid/support/v7/view/menu/E;-><init>(Landroid/content/Context;La/b/c/c/a/c;)V

    return-object v0
.end method
