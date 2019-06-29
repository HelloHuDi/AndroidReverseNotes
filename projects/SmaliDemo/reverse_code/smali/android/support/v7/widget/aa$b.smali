.class Landroid/support/v7/widget/aa$b;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/aa;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "b"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/aa;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/aa;)V
    .locals 0

    .line 552
    iput-object p1, p0, Landroid/support/v7/widget/aa$b;->a:Landroid/support/v7/widget/aa;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 553
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .line 557
    move-object v0, p1

    check-cast v0, Landroid/support/v7/widget/aa$c;

    .line 558
    .local v0, "tabView":Landroid/support/v7/widget/aa$c;
    invoke-virtual {v0}, Landroid/support/v7/widget/aa$c;->a()Landroid/support/v7/app/a$c;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/app/a$c;->e()V

    .line 559
    iget-object v1, p0, Landroid/support/v7/widget/aa$b;->a:Landroid/support/v7/widget/aa;

    iget-object v1, v1, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    .line 560
    .local v1, "tabCount":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_1

    .line 561
    iget-object v3, p0, Landroid/support/v7/widget/aa$b;->a:Landroid/support/v7/widget/aa;

    iget-object v3, v3, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {v3, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 562
    .local v3, "child":Landroid/view/View;
    if-ne v3, p1, :cond_0

    const/4 v4, 0x1

    goto :goto_1

    :cond_0
    const/4 v4, 0x0

    :goto_1
    invoke-virtual {v3, v4}, Landroid/view/View;->setSelected(Z)V

    .line 560
    .end local v3    # "child":Landroid/view/View;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 564
    .end local v2    # "i":I
    :cond_1
    return-void
.end method
