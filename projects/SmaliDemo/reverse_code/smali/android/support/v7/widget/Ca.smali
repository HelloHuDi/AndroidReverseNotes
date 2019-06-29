.class Landroid/support/v7/widget/Ca;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/Ea;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/Ea;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/Ea;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/Ea;

    .line 54
    iput-object p1, p0, Landroid/support/v7/widget/Ca;->a:Landroid/support/v7/widget/Ea;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 57
    iget-object v0, p0, Landroid/support/v7/widget/Ca;->a:Landroid/support/v7/widget/Ea;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Ea;->a(Z)V

    .line 58
    return-void
.end method
