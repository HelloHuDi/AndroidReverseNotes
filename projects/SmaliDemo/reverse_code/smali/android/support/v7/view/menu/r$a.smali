.class Landroid/support/v7/view/menu/r$a;
.super Landroid/support/v7/view/menu/q$a;
.source ""

# interfaces
.implements Landroid/view/ActionProvider$VisibilityListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/view/menu/r;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "a"
.end annotation


# instance fields
.field f:La/b/c/g/e$b;

.field final synthetic g:Landroid/support/v7/view/menu/r;


# direct methods
.method public constructor <init>(Landroid/support/v7/view/menu/r;Landroid/content/Context;Landroid/view/ActionProvider;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/view/menu/r;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "inner"    # Landroid/view/ActionProvider;

    .line 51
    iput-object p1, p0, Landroid/support/v7/view/menu/r$a;->g:Landroid/support/v7/view/menu/r;

    .line 52
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v7/view/menu/q$a;-><init>(Landroid/support/v7/view/menu/q;Landroid/content/Context;Landroid/view/ActionProvider;)V

    .line 53
    return-void
.end method


# virtual methods
.method public a(Landroid/view/MenuItem;)Landroid/view/View;
    .locals 1
    .param p1, "forItem"    # Landroid/view/MenuItem;

    .line 57
    iget-object v0, p0, Landroid/support/v7/view/menu/q$a;->d:Landroid/view/ActionProvider;

    invoke-virtual {v0, p1}, Landroid/view/ActionProvider;->onCreateActionView(Landroid/view/MenuItem;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public a(La/b/c/g/e$b;)V
    .locals 2
    .param p1, "listener"    # La/b/c/g/e$b;

    .line 77
    iput-object p1, p0, Landroid/support/v7/view/menu/r$a;->f:La/b/c/g/e$b;

    .line 78
    iget-object v0, p0, Landroid/support/v7/view/menu/q$a;->d:Landroid/view/ActionProvider;

    if-eqz p1, :cond_0

    move-object v1, p0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    invoke-virtual {v0, v1}, Landroid/view/ActionProvider;->setVisibilityListener(Landroid/view/ActionProvider$VisibilityListener;)V

    .line 79
    return-void
.end method

.method public b()Z
    .locals 1

    .line 67
    iget-object v0, p0, Landroid/support/v7/view/menu/q$a;->d:Landroid/view/ActionProvider;

    invoke-virtual {v0}, Landroid/view/ActionProvider;->isVisible()Z

    move-result v0

    return v0
.end method

.method public e()Z
    .locals 1

    .line 62
    iget-object v0, p0, Landroid/support/v7/view/menu/q$a;->d:Landroid/view/ActionProvider;

    invoke-virtual {v0}, Landroid/view/ActionProvider;->overridesItemVisibility()Z

    move-result v0

    return v0
.end method

.method public onActionProviderVisibilityChanged(Z)V
    .locals 1
    .param p1, "isVisible"    # Z

    .line 83
    iget-object v0, p0, Landroid/support/v7/view/menu/r$a;->f:La/b/c/g/e$b;

    if-eqz v0, :cond_0

    .line 84
    invoke-interface {v0, p1}, La/b/c/g/e$b;->onActionProviderVisibilityChanged(Z)V

    .line 86
    :cond_0
    return-void
.end method
