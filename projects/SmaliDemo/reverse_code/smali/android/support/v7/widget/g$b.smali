.class Landroid/support/v7/widget/g$b;
.super Landroid/support/v7/view/menu/ActionMenuItemView$b;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "b"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/g;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/g;)V
    .locals 0

    .line 814
    iput-object p1, p0, Landroid/support/v7/widget/g$b;->a:Landroid/support/v7/widget/g;

    invoke-direct {p0}, Landroid/support/v7/view/menu/ActionMenuItemView$b;-><init>()V

    .line 815
    return-void
.end method


# virtual methods
.method public a()Landroid/support/v7/view/menu/z;
    .locals 1

    .line 819
    iget-object v0, p0, Landroid/support/v7/widget/g$b;->a:Landroid/support/v7/widget/g;

    iget-object v0, v0, Landroid/support/v7/widget/g;->A:Landroid/support/v7/widget/g$a;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/view/menu/u;->b()Landroid/support/v7/view/menu/s;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method
