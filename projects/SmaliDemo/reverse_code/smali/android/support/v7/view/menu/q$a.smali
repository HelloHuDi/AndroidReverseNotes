.class Landroid/support/v7/view/menu/q$a;
.super La/b/c/g/e;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/view/menu/q;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "a"
.end annotation


# instance fields
.field final d:Landroid/view/ActionProvider;

.field final synthetic e:Landroid/support/v7/view/menu/q;


# direct methods
.method public constructor <init>(Landroid/support/v7/view/menu/q;Landroid/content/Context;Landroid/view/ActionProvider;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/view/menu/q;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "inner"    # Landroid/view/ActionProvider;

    .line 422
    iput-object p1, p0, Landroid/support/v7/view/menu/q$a;->e:Landroid/support/v7/view/menu/q;

    .line 423
    invoke-direct {p0, p2}, La/b/c/g/e;-><init>(Landroid/content/Context;)V

    .line 424
    iput-object p3, p0, Landroid/support/v7/view/menu/q$a;->d:Landroid/view/ActionProvider;

    .line 425
    return-void
.end method


# virtual methods
.method public a(Landroid/view/SubMenu;)V
    .locals 2
    .param p1, "subMenu"    # Landroid/view/SubMenu;

    .line 444
    iget-object v0, p0, Landroid/support/v7/view/menu/q$a;->d:Landroid/view/ActionProvider;

    iget-object v1, p0, Landroid/support/v7/view/menu/q$a;->e:Landroid/support/v7/view/menu/q;

    invoke-virtual {v1, p1}, Landroid/support/v7/view/menu/c;->a(Landroid/view/SubMenu;)Landroid/view/SubMenu;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ActionProvider;->onPrepareSubMenu(Landroid/view/SubMenu;)V

    .line 445
    return-void
.end method

.method public a()Z
    .locals 1

    .line 439
    iget-object v0, p0, Landroid/support/v7/view/menu/q$a;->d:Landroid/view/ActionProvider;

    invoke-virtual {v0}, Landroid/view/ActionProvider;->hasSubMenu()Z

    move-result v0

    return v0
.end method

.method public c()Landroid/view/View;
    .locals 1

    .line 429
    iget-object v0, p0, Landroid/support/v7/view/menu/q$a;->d:Landroid/view/ActionProvider;

    invoke-virtual {v0}, Landroid/view/ActionProvider;->onCreateActionView()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public d()Z
    .locals 1

    .line 434
    iget-object v0, p0, Landroid/support/v7/view/menu/q$a;->d:Landroid/view/ActionProvider;

    invoke-virtual {v0}, Landroid/view/ActionProvider;->onPerformDefaultAction()Z

    move-result v0

    return v0
.end method
