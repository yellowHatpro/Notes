  //UI
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'

    //Navigation
    implementation 'androidx.navigation:navigation-fragment-ktx:2.4.1'
    implementation 'androidx.navigation:navigation-ui-ktx:2.4.1'

    //Scalable Unit Scales
    implementation 'com.intuit.sdp:sdp-android:1.0.6'
    implementation 'com.intuit.ssp:ssp-android:1.0.6'

    //Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0'

    //Lifecycle components
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.4.1"
    implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.4.1"
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"


    //Image downloading and Caching library
    implementation 'com.github.bumptech.glide:glide:4.13.0'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    kapt 'com.github.bumptech.glide:compiler:4.13.0'

    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation "com.squareup.okhttp3:okhttp:5.0.0-alpha.4"

    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    // Firebase
    implementation 'com.google.firebase:firebase-auth-ktx:21.0.1'
    implementation 'com.google.firebase:firebase-analytics-ktx'
    implementation platform('com.google.firebase:firebase-bom:29.1.0')
    implementation 'com.google.android.gms:play-services-auth:20.1.0'
    implementation 'com.google.firebase:firebase-database'
    implementation 'com.google.firebase:firebase-database-ktx'