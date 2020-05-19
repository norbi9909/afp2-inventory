import React, {Component} from 'react';
import {Jumbotron} from 'react-bootstrap';

export default class Welcome extends Component{
    render(){
        return(
            <Jumbotron className="bg-dark text-white">
                <h1>Welcome to the Inventory!</h1>
                <blockquote className="blockquote mb-0">
                    <p>
                        Something comes here.
                    </p>
                    <footer className="blockquote-footer">
                        Asd Asd
                    </footer>
                </blockquote>
            </Jumbotron>
        );
    }
}