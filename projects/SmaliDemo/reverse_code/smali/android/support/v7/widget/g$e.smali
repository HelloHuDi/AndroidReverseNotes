.class Landroid/support/v7/widget/g$e;
.super Landroid/support/v7/view/menu/u;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "e"
.end annotation


# instance fields
.field final synthetic m:Landroid/support/v7/widget/g;


# direct methods
.method public constructor <init>(Landroid/support/v7/widget/g;Landroid/content/Context;Landroid/support/v7/view/menu/l;Landroid/view/View;Z)V
    .locals 6
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "menu"    # Landroid/support/v7/view/menu/l;
    .param p4, "anchorView"    # Landroid/view/View;
    .param p5, "overflowOnly"    # Z

    .line 729
    iput-object p1, p0, Landroid/support/v7/widget/g$e;->m:Landroid/support/v7/widget/g;

    .line 730
    sget v5, La/b/d/a/a;->actionOverflowMenuStyle:I

    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    move v4, p5

    invoke-direct/range {v0 .. v5}, Landroid/support/v7/view/menu/u;-><init>(Landroid/content/Context;Landroid/support/v7/view/menu/l;Landroid/view/View;ZI)V

    .line 731
    const v0, 0x800005

    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/u;->a(I)V

    .line 732
    iget-object p1, p1, Landroid/support/v7/widget/g;->D:Landroid/support/v7/widget/g$f;

    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/u;->a(Landroid/support/v7/view/menu/v$a;)V

    .line 733
    return-void
.end method


# virtual methods
.method protected d()V
    .locals 2

    .line 737
    iget-object v0, p0, Landroid/support/v7/widget/g$e;->m:Landroid/support/v7/widget/g;

    invoke-static {v0}, Landroid/support/v7/widget/g;->a(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/l;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 738
    iget-object v0, p0, Landroid/support/v7/widget/g$e;->m:Landroid/support/v7/widget/g;

    invoke-static {v0}, Landroid/support/v7/widget/g;->b(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/l;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->close()V

    .line 740
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/g$e;->m:Landroid/support/v7/widget/g;

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/support/v7/widget/g;->z:Landroid/support/v7/widget/g$e;

    .line 742
    invoke-super {p0}, Landroid/support/v7/view/menu/u;->d()V

    .line 743
    return-void
.end method
