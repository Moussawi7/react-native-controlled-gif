# react-native-controlled-gif
Control GIF animation

![](https://raw.githubusercontent.com/felipecsl/GifImageView/master/demo.gif)

## Requirements:
-  `react-native` >=0.49.3

### Android Installation
1. Run `npm install --save https://github.com/Moussawi7/react-native-controlled-gif`.
2. Run `react-native link`.
3. Run the project 🎉.

### API Reference

###### First import ControlledGif
```js
import ControlledGifView from 'react-native-controlled-gif';
```
and in the render
```js
<ControlledGifView
    style={{width:200,height:166,backgroundColor:"yellow"}}
    url="http://katemobile.ru/tmp/sample3.gif"
    isPlaying={true}
    onReady={(width,height)=>this.onReady(width,height)}
    onError={(error)=>this.onError(error)}/>
```

### Credits

Thanks to [felipecsl](https://github.com/felipecsl/GifImageView) for native android development.
