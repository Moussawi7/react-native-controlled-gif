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
    onError={(code,message)=>this.onError(code,message)}/>
```

### Credits

Thanks to [felipecsl](https://github.com/felipecsl/GifImageView) for native android development.

### License

The MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
