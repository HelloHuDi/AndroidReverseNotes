.class Landroid/support/v7/widget/aa$a;
.super Landroid/widget/BaseAdapter;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/aa;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "a"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/aa;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/aa;)V
    .locals 0

    .line 522
    iput-object p1, p0, Landroid/support/v7/widget/aa$a;->a:Landroid/support/v7/widget/aa;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 523
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .line 527
    iget-object v0, p0, Landroid/support/v7/widget/aa$a;->a:Landroid/support/v7/widget/aa;

    iget-object v0, v0, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .line 532
    iget-object v0, p0, Landroid/support/v7/widget/aa$a;->a:Landroid/support/v7/widget/aa;

    iget-object v0, v0, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/aa$c;

    invoke-virtual {v0}, Landroid/support/v7/widget/aa$c;->a()Landroid/support/v7/app/a$c;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .line 537
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .line 542
    if-nez p2, :cond_0

    .line 543
    iget-object v0, p0, Landroid/support/v7/widget/aa$a;->a:Landroid/support/v7/widget/aa;

    invoke-virtual {p0, p1}, Landroid/support/v7/widget/aa$a;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v7/app/a$c;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/widget/aa;->a(Landroid/support/v7/app/a$c;Z)Landroid/support/v7/widget/aa$c;

    move-result-object p2

    goto :goto_0

    .line 545
    :cond_0
    move-object v0, p2

    check-cast v0, Landroid/support/v7/widget/aa$c;

    invoke-virtual {p0, p1}, Landroid/support/v7/widget/aa$a;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v7/app/a$c;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/aa$c;->a(Landroid/support/v7/app/a$c;)V

    .line 547
    :goto_0
    return-object p2
.end method
