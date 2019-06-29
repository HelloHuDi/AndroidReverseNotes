.class Landroid/support/v7/app/r;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/g/q;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/app/x;->u()Landroid/view/ViewGroup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/x;


# direct methods
.method constructor <init>(Landroid/support/v7/app/x;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/x;

    .line 638
    iput-object p1, p0, Landroid/support/v7/app/r;->a:Landroid/support/v7/app/x;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;La/b/c/g/E;)La/b/c/g/E;
    .locals 5
    .param p1, "v"    # Landroid/view/View;
    .param p2, "insets"    # La/b/c/g/E;

    .line 642
    invoke-virtual {p2}, La/b/c/g/E;->d()I

    move-result v0

    .line 643
    .local v0, "top":I
    iget-object v1, p0, Landroid/support/v7/app/r;->a:Landroid/support/v7/app/x;

    invoke-virtual {v1, v0}, Landroid/support/v7/app/x;->i(I)I

    move-result v1

    .line 645
    .local v1, "newTop":I
    if-eq v0, v1, :cond_0

    .line 646
    nop

    .line 647
    invoke-virtual {p2}, La/b/c/g/E;->b()I

    move-result v2

    .line 649
    invoke-virtual {p2}, La/b/c/g/E;->c()I

    move-result v3

    .line 650
    invoke-virtual {p2}, La/b/c/g/E;->a()I

    move-result v4

    .line 646
    invoke-virtual {p2, v2, v1, v3, v4}, La/b/c/g/E;->a(IIII)La/b/c/g/E;

    move-result-object p2

    .line 654
    :cond_0
    invoke-static {p1, p2}, La/b/c/g/u;->a(Landroid/view/View;La/b/c/g/E;)La/b/c/g/E;

    move-result-object v2

    return-object v2
.end method
