.class Landroid/support/v7/widget/ua;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v7/widget/ActionMenuView$e;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/Toolbar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/Toolbar;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/Toolbar;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/Toolbar;

    .line 200
    iput-object p1, p0, Landroid/support/v7/widget/ua;->a:Landroid/support/v7/widget/Toolbar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onMenuItemClick(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .line 203
    iget-object v0, p0, Landroid/support/v7/widget/ua;->a:Landroid/support/v7/widget/Toolbar;

    iget-object v0, v0, Landroid/support/v7/widget/Toolbar;->G:Landroid/support/v7/widget/Toolbar$c;

    if-eqz v0, :cond_0

    .line 204
    invoke-interface {v0, p1}, Landroid/support/v7/widget/Toolbar$c;->onMenuItemClick(Landroid/view/MenuItem;)Z

    move-result v0

    return v0

    .line 206
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
