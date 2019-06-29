.class final Landroid/support/v7/app/x$a;
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
    name = "a"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/x;


# direct methods
.method constructor <init>(Landroid/support/v7/app/x;)V
    .locals 0

    .line 2240
    iput-object p1, p0, Landroid/support/v7/app/x$a;->a:Landroid/support/v7/app/x;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2241
    return-void
.end method


# virtual methods
.method public a(Landroid/support/v7/view/menu/l;Z)V
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "allMenusAreClosing"    # Z

    .line 2254
    iget-object v0, p0, Landroid/support/v7/app/x$a;->a:Landroid/support/v7/app/x;

    invoke-virtual {v0, p1}, Landroid/support/v7/app/x;->b(Landroid/support/v7/view/menu/l;)V

    .line 2255
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;)Z
    .locals 2
    .param p1, "subMenu"    # Landroid/support/v7/view/menu/l;

    .line 2245
    iget-object v0, p0, Landroid/support/v7/app/x$a;->a:Landroid/support/v7/app/x;

    invoke-virtual {v0}, Landroid/support/v7/app/x;->o()Landroid/view/Window$Callback;

    move-result-object v0

    .line 2246
    .local v0, "cb":Landroid/view/Window$Callback;
    if-eqz v0, :cond_0

    .line 2247
    const/16 v1, 0x6c

    invoke-interface {v0, v1, p1}, Landroid/view/Window$Callback;->onMenuOpened(ILandroid/view/Menu;)Z

    .line 2249
    :cond_0
    const/4 v1, 0x1

    return v1
.end method
