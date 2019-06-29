.class Landroid/support/v7/widget/g$a;
.super Landroid/support/v7/view/menu/u;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "a"
.end annotation


# instance fields
.field final synthetic m:Landroid/support/v7/widget/g;


# direct methods
.method public constructor <init>(Landroid/support/v7/widget/g;Landroid/content/Context;Landroid/support/v7/view/menu/D;Landroid/view/View;)V
    .locals 6
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "subMenu"    # Landroid/support/v7/view/menu/D;
    .param p4, "anchorView"    # Landroid/view/View;

    .line 747
    iput-object p1, p0, Landroid/support/v7/widget/g$a;->m:Landroid/support/v7/widget/g;

    .line 748
    sget v5, La/b/d/a/a;->actionOverflowMenuStyle:I

    const/4 v4, 0x0

    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    invoke-direct/range {v0 .. v5}, Landroid/support/v7/view/menu/u;-><init>(Landroid/content/Context;Landroid/support/v7/view/menu/l;Landroid/view/View;ZI)V

    .line 750
    invoke-virtual {p3}, Landroid/support/v7/view/menu/D;->getItem()Landroid/view/MenuItem;

    move-result-object v0

    check-cast v0, Landroid/support/v7/view/menu/p;

    .line 751
    .local v0, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->h()Z

    move-result v1

    if-nez v1, :cond_1

    .line 753
    iget-object v1, p1, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    if-nez v1, :cond_0

    invoke-static {p1}, Landroid/support/v7/widget/g;->c(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/w;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    :cond_0
    invoke-virtual {p0, v1}, Landroid/support/v7/view/menu/u;->a(Landroid/view/View;)V

    .line 756
    :cond_1
    iget-object p1, p1, Landroid/support/v7/widget/g;->D:Landroid/support/v7/widget/g$f;

    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/u;->a(Landroid/support/v7/view/menu/v$a;)V

    .line 757
    return-void
.end method


# virtual methods
.method protected d()V
    .locals 2

    .line 761
    iget-object v0, p0, Landroid/support/v7/widget/g$a;->m:Landroid/support/v7/widget/g;

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/support/v7/widget/g;->A:Landroid/support/v7/widget/g$a;

    .line 762
    const/4 v1, 0x0

    iput v1, v0, Landroid/support/v7/widget/g;->E:I

    .line 764
    invoke-super {p0}, Landroid/support/v7/view/menu/u;->d()V

    .line 765
    return-void
.end method
