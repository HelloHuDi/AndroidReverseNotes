.class final Landroid/support/v7/app/x$g;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v7/view/menu/v$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/x;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "g"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/x;


# direct methods
.method constructor <init>(Landroid/support/v7/app/x;)V
    .locals 0

    .line 2207
    iput-object p1, p0, Landroid/support/v7/app/x$g;->a:Landroid/support/v7/app/x;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2208
    return-void
.end method


# virtual methods
.method public a(Landroid/support/v7/view/menu/l;Z)V
    .locals 6
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "allMenusAreClosing"    # Z

    .line 2212
    invoke-virtual {p1}, Landroid/support/v7/view/menu/l;->m()Landroid/support/v7/view/menu/l;

    move-result-object v0

    .line 2213
    .local v0, "parentMenu":Landroid/view/Menu;
    const/4 v1, 0x1

    if-eq v0, p1, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    .line 2214
    .local v2, "isSubMenu":Z
    :goto_0
    iget-object v3, p0, Landroid/support/v7/app/x$g;->a:Landroid/support/v7/app/x;

    if-eqz v2, :cond_1

    move-object v4, v0

    goto :goto_1

    :cond_1
    move-object v4, p1

    :goto_1
    invoke-virtual {v3, v4}, Landroid/support/v7/app/x;->a(Landroid/view/Menu;)Landroid/support/v7/app/x$f;

    move-result-object v3

    .line 2215
    .local v3, "panel":Landroid/support/v7/app/x$f;
    if-eqz v3, :cond_3

    .line 2216
    if-eqz v2, :cond_2

    .line 2217
    iget-object v4, p0, Landroid/support/v7/app/x$g;->a:Landroid/support/v7/app/x;

    iget v5, v3, Landroid/support/v7/app/x$f;->a:I

    invoke-virtual {v4, v5, v3, v0}, Landroid/support/v7/app/x;->a(ILandroid/support/v7/app/x$f;Landroid/view/Menu;)V

    .line 2218
    iget-object v4, p0, Landroid/support/v7/app/x$g;->a:Landroid/support/v7/app/x;

    invoke-virtual {v4, v3, v1}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Z)V

    goto :goto_2

    .line 2222
    :cond_2
    iget-object v1, p0, Landroid/support/v7/app/x$g;->a:Landroid/support/v7/app/x;

    invoke-virtual {v1, v3, p2}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Z)V

    .line 2225
    :cond_3
    :goto_2
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;)Z
    .locals 2
    .param p1, "subMenu"    # Landroid/support/v7/view/menu/l;

    .line 2229
    if-nez p1, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/x$g;->a:Landroid/support/v7/app/x;

    iget-boolean v1, v0, Landroid/support/v7/app/x;->B:Z

    if-eqz v1, :cond_0

    .line 2230
    invoke-virtual {v0}, Landroid/support/v7/app/x;->o()Landroid/view/Window$Callback;

    move-result-object v0

    .line 2231
    .local v0, "cb":Landroid/view/Window$Callback;
    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/v7/app/x$g;->a:Landroid/support/v7/app/x;

    iget-boolean v1, v1, Landroid/support/v7/app/x;->K:Z

    if-nez v1, :cond_0

    .line 2232
    const/16 v1, 0x6c

    invoke-interface {v0, v1, p1}, Landroid/view/Window$Callback;->onMenuOpened(ILandroid/view/Menu;)Z

    .line 2235
    .end local v0    # "cb":Landroid/view/Window$Callback;
    :cond_0
    const/4 v0, 0x1

    return v0
.end method
