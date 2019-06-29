.class public La/b/c/g/a/b;
.super Ljava/lang/Object;
.source ""


# instance fields
.field private final a:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/Object;

    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 121
    iput-object p1, p0, La/b/c/g/a/b;->a:Ljava/lang/Object;

    .line 122
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/Object;
    .locals 1

    .line 128
    iget-object v0, p0, La/b/c/g/a/b;->a:Ljava/lang/Object;

    return-object v0
.end method
