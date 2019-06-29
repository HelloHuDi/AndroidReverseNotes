.class Landroid/support/v7/app/t;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v7/widget/ContentFrameLayout$a;


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

    .line 715
    iput-object p1, p0, Landroid/support/v7/app/t;->a:Landroid/support/v7/app/x;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 0

    .line 717
    return-void
.end method

.method public onDetachedFromWindow()V
    .locals 1

    .line 721
    iget-object v0, p0, Landroid/support/v7/app/t;->a:Landroid/support/v7/app/x;

    invoke-virtual {v0}, Landroid/support/v7/app/x;->k()V

    .line 722
    return-void
.end method
