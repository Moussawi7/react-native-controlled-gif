import React, {Component} from 'react';
import { requireNativeComponent, ViewPropTypes,ViewStylePropTypes } from 'react-native';
import PropTypes from 'prop-types';

class ControlledGifInterface extends Component {

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
    this.props.onError&&this.props.onError(event.nativeEvent.code,event.nativeEvent.message);
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
    return (<ControlledGifView {...nativeProps}/>);
  }

}

const ControlledGifView = requireNativeComponent('RCTControlledGifView', ControlledGifInterface);
export default ControlledGifInterface;
