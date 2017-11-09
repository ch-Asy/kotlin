package com.cn.kotlin.life.dagger;



import dagger.Module;

@Module(includes = ViewModelModule.class)
class AppModule {
//    @Singleton
//    @Provides
//    GithubService provideGithubService() {
//        return new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
////                .build()
////                .create(GithubService.class);
////    }
//
//    @Singleton @Provides
//    GithubDb provideDb(Application app) {
//        return Room.databaseBuilder(app, GithubDb.class,"github.db").build();
//    }


}