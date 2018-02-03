import React, {Component} from 'react';
import { requireNativeComponent, ViewPropTypes,ViewStylePropTypes } from 'react-native';
import PropTypes from 'prop-types';

class ControlledGif extends Component {

  constructor(props, context){
    super(props, context);
    this._onReady = this._onReady.bind(this);
    this._onError = this._onError.bind(this);
  }

  static propTypes = {
    ...ViewPropTypes,
    url: PropTypes.string,
    isPlaying:PropTypes.bool,
    onReady:PropTypes.func,
    onError:PropTypes.func
  }

  static defaultProps= {
    isPlaying: true
  }

  _onReady(event){
    this.props.onReady&&this.props.onReady(parseInt(event.nativeEvent.width),parseInt(event.nativeEvent.height));
  }

  _onError(event) {
    console.warn(JSON.stringify(event.nativeEvent));
    this.props.onError && this.props.onError(event.nativeEvent);
  }

  render() {
    const nativeProps = {
      onReady: this._onReady,
      onError: this._onError,
      url:this.props.url,
      isPlaying:this.props.isPlaying,
      style:this.props.style,
      ...ViewStylePropTypes
    };
    return (<RCTControlledGifView {...nativeProps}/>);
  }

}

const RCTControlledGifView = requireNativeComponent('RCTControlledGifView', ControlledGif);
export default ControlledGif;
